package com.boardsite.adm.boardsiteadm.service.travel;


import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgency;
import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgencyList;
import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgencyReservation;
import com.boardsite.adm.boardsiteadm.domain.user.TripUser;
import com.boardsite.adm.boardsiteadm.dto.common.AttachFileDto;
import com.boardsite.adm.boardsiteadm.dto.request.travel.TravelAgencyRerservationRefundRequest;
import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyReservationOnlyListDto;
import com.boardsite.adm.boardsiteadm.dto.travel.TravelAgencyReservationDto;
import com.boardsite.adm.boardsiteadm.exception.BoardSiteException;
import com.boardsite.adm.boardsiteadm.exception.ErrorCode;
import com.boardsite.adm.boardsiteadm.repository.travel.TravelAgencyListRepository;
import com.boardsite.adm.boardsiteadm.repository.travel.TravelAgencyRepository;
import com.boardsite.adm.boardsiteadm.repository.travel.TravelAgencyReservationRepository;
import com.boardsite.adm.boardsiteadm.repository.user.TripUserRepository;
import com.boardsite.adm.boardsiteadm.service.common.FileUploadService;
import com.boardsite.adm.boardsiteadm.service.common.SequenceService;
import com.cloudinary.Cloudinary;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TravelAgencyReservationService {

    private final TravelAgencyReservationRepository travelAgencyReservationRepository;

    private final TravelAgencyListRepository travelAgencyListRepository;

    private final TravelAgencyRepository travelAgencyRepository;

    private final TripUserRepository tripUserRepository;
    @Value("https://api.iamport.kr/payments/cancel")
    private String iamPortRefund;

    @Value("https://api.iamport.kr/users/getToken")
    private String accessToken;

    @Value("${import.rest-api}")
    private String imPortRestApi;

    @Value("${import.rest-api-secret}")
    private String imPortRestApiSecret;

    private final SequenceService sequenceService;

    @Value("${custom.path.upload-images}")
    private String path;

    @Value("${cloudinary.cloud_name}")
    private String cloud_name;

    @Value("${cloudinary.api_key}")
    private String api_key;

    @Value("${cloudinary.api_secret}")
    private String api_secret;

    private final FileUploadService fileUploadService;

    @Transactional
    public Boolean travelAgencyReserSave(TravelAgencyReservationDto dto) {

        TripUser tripUser = tripUserRepository.findById(dto.tripUser().id()).orElseThrow(()->new BoardSiteException(ErrorCode.USER_NOT_FOUND));
        TravelAgency travelAgency = travelAgencyRepository.findByIdAndDeleted(dto.travelAgencyId(),false).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_AGENCY_NOT_FOUND));
        TravelAgencyList travelAgencyList = travelAgencyListRepository.findByIdAndDeleted(dto.travelAgencyListId(),false).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_AGENCY_LIST_NOT_FOUND));
        travelAgencyReservationRepository.save(dto.toEntity(travelAgency,travelAgencyList,tripUser));
        TravelAgencyReservation travelAgencyReservation =travelAgencyReservationRepository.findByImpUidAndMerchantUid(dto.impUid(),dto.merchantUid()).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_PAY_NOT_FOUND));
        TravelAgencyReservation updTravelAgencyReservation = travelAgencyReservationRepository.findById(travelAgencyReservation.getId()).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_PAY_NOT_FOUND));

        int userPaid   = updTravelAgencyReservation.getPaid();
        int userCount  = updTravelAgencyReservation.getPersonCount();
        int travelPaid = travelAgencyList.getSalePaid();

        if(userPaid == (userCount*travelPaid)){
            updTravelAgencyReservation.setDeleted(false);
           Long qrId= saveQr(dto.tripUser().id(),travelAgencyReservation.getId(),updTravelAgencyReservation.getPersonCount(),updTravelAgencyReservation.isDeleted());
            updTravelAgencyReservation.setQrCodeId(qrId);
        } else {
            updTravelAgencyReservation.setFailReason("스크립트 결제 금액 변조");
            updTravelAgencyReservation.setDeleted(true);
        }
        return updTravelAgencyReservation.isDeleted();
    }

    @Transactional(readOnly = true)
    public Page<TravelAgencyReservationOnlyListDto> getReservationList(Long tripUserId , Pageable pageable) {
        return travelAgencyReservationRepository.findCustomList(tripUserId,pageable);
    }

    @Transactional
    public boolean iamPortRefund(TravelAgencyRerservationRefundRequest travelAgencyRerservationRefundRequest) throws ParseException {
        WebClient webClient = WebClient.create();
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        MultiValueMap<String, String> refundData = new LinkedMultiValueMap<>();
        formData.add("imp_key",imPortRestApi);
        formData.add("imp_secret",imPortRestApiSecret);

        refundData.add("imp_uid",travelAgencyRerservationRefundRequest.impUid());
        refundData.add("reason","개인 변심");
        refundData.add("amount", String.valueOf(travelAgencyRerservationRefundRequest.money()));

        var response = webClient.post()
                .uri(accessToken)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(formData))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(response);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("response");

        var imPortaccessToken =  jsonObject1.get("access_token");

        var refundResponse = webClient.post()
                .uri(iamPortRefund)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization",String.valueOf(imPortaccessToken))
                .body(BodyInserters.fromFormData(refundData))
                .retrieve()
                .bodyToMono(JSONObject.class)
                .block();

        if(!refundResponse.get("code").equals(0)){
            throw  new BoardSiteException(ErrorCode.REFUND_FAIL);
        } else {
            var travelAgencyListDetail = travelAgencyListRepository.findByIdAndDeleted(travelAgencyRerservationRefundRequest.travelAgencyListId(),false).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_AGENCY_DETAIL_NOT_FOUND));
            travelAgencyListDetail.personMinusCount(travelAgencyListDetail.getPersonCount(),travelAgencyRerservationRefundRequest.personCount());
            var refundId = travelAgencyReservationRepository.findById(travelAgencyRerservationRefundRequest.id()).orElseThrow();
            refundId.setDeleted(true);
            refundId.setQrCodeId(null);
            return true;
        }

    }

    public Long saveQr(Long id , Long travelAgencyResId , int count , boolean isDeleted) {

        Map config = new HashMap();

        config.put("cloud_name", cloud_name);
        config.put("api_key", api_key);
        config.put("api_secret", api_secret);

        Cloudinary cloudinary = new Cloudinary(config);

        Long fileId = sequenceService.getSeq();
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String datefolder = sdf.format(nowDate).toString();
        File dir = new File(path, datefolder);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        //개발
//        String content = "http://localhost:8081?id="+id+"&travelAgencyResId="+travelAgencyResId+"&count="+count+"&deleted="+isDeleted;
        //heroku
        String content = "https://board-site-production.up.railway.app?id="+id+"&travelAgencyResId="+travelAgencyResId+"&count="+count+"&deleted="+isDeleted;
        try{
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 200, 200);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            String new_file_name = UUID.randomUUID()+".png";
            File temp = new File(dir + File.separator + new_file_name);
            ImageIO.write(bufferedImage, "png", temp);

            String filePath = cloudinary.uploader().upload(temp, null).get("secure_url").toString();
            String[] fileFileName = filePath.split("/");


            var attachFileDto = AttachFileDto.of(fileId,
                    1,
                    new_file_name,
                    fileFileName[7],
                    filePath,
                    filePath,
                    0L
            );
            fileUploadService.saveImage(Collections.singletonList(attachFileDto));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileId;
    }


}

