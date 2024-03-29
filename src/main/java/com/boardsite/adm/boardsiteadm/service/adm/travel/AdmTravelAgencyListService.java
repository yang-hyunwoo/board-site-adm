package com.boardsite.adm.boardsiteadm.service.adm.travel;


import com.boardsite.adm.boardsiteadm.domain.constant.SearchAdmTravelListType;
import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgency;
import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgencyList;
import com.boardsite.adm.boardsiteadm.dto.adm.travel.AdmTravelAgencyReservationDto;
import com.boardsite.adm.boardsiteadm.dto.request.adm.travel.QrcodeUserUpdateRequest;
import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyListOnlyListDto;
import com.boardsite.adm.boardsiteadm.dto.security.TripUserPrincipal;
import com.boardsite.adm.boardsiteadm.dto.travel.TravelAgencyListDto;
import com.boardsite.adm.boardsiteadm.exception.BoardSiteException;
import com.boardsite.adm.boardsiteadm.exception.ErrorCode;
import com.boardsite.adm.boardsiteadm.repository.adm.travel.AdmTravelAgencyListRepository;
import com.boardsite.adm.boardsiteadm.repository.adm.travel.AdmTravelAgencyRepository;
import com.boardsite.adm.boardsiteadm.repository.adm.travel.AdmTravelAgencyReservationRepository;
import com.boardsite.adm.boardsiteadm.repository.user.TripUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdmTravelAgencyListService {

    private final AdmTravelAgencyListRepository admTravelAgencyListRepository;

    private final AdmTravelAgencyReservationRepository admTravelAgencyReservationRepository;

    private final AdmTravelAgencyRepository admTravelAgencyRepository;

    private final TripUserRepository tripUserRepository;

    @Transactional(readOnly = true)
    public  Page<TravelAgencyListOnlyListDto> travelAgencyTripList(SearchAdmTravelListType inputSearch,
                                                                   SearchAdmTravelListType dateSearch,
                                                                   String startAt,
                                                                   String endAt,
                                                                   String input,
                                                                   TripUserPrincipal tripUserPrincipal,
                                                                   Pageable pageable) {
        //작성일 기준
        String localDateStartDate = startAt+" 00:00:00.000000";
        String localDateStartDate2 = endAt+" 23:59:59.999999";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse(localDateStartDate, formatter);
        LocalDateTime dateTime2 = LocalDateTime.parse(localDateStartDate2, formatter);

        if(tripUserPrincipal.role().equals("SUPER")) {
            //작성일 기준
            if (dateSearch.toString().equals("CREATEDAT")) {
                if (input == null || input.isBlank()) {
                    return admTravelAgencyListRepository.findCustomByCreatedAtBetweenOrderById(dateTime, dateTime2, pageable);
                } else {
                    if (inputSearch.toString().equals("TITLE")) { //제목으로 검색 시
                        return admTravelAgencyListRepository.findCustomByTitleContainingAndCreatedAtBetweenOrderById(input, dateTime, dateTime2, pageable);
                    } else {    //여행사 이름으로 검색 시
                        return admTravelAgencyListRepository.findByCustomTravelAgencyNameContainingAndCreatedAtBetweenOrderById(input, dateTime, dateTime2, pageable);
                    }
                }
//                //출발일 기준
            } else {
                if (input == null || input.isBlank()) {
                    return admTravelAgencyListRepository.findCustomByTravelRealTripAtBetweenOrderById(startAt.replaceAll("-", ""), endAt.replaceAll("-", ""), pageable);
                } else {
                    if (inputSearch.toString().equals("TITLE")) {
                        return admTravelAgencyListRepository.findCustomByTitleContainingAndTravelRealTripAtBetweenOrderById(input, startAt.replaceAll("-", ""), endAt.replaceAll("-", ""), pageable);
                    } else {
                        return admTravelAgencyListRepository.findCustomByTravelAgencyNameContainingAndTravelRealTripAtBetweenOrderById(input, startAt.replaceAll("-", ""), endAt.replaceAll("-", ""), pageable);
                    }
                }
            }
        } else {
            //작성일 기준
            if (dateSearch.toString().equals("CREATEDAT")) {
                if (input == null || input.isBlank()) {
                    return admTravelAgencyListRepository.findCustomByTravelAgency_IdAndCreatedAtBetweenOrderById(tripUserPrincipal.travelAgencyId(),dateTime, dateTime2, pageable);
                } else {
                    if (inputSearch.toString().equals("TITLE")) { //제목으로 검색 시
                        return admTravelAgencyListRepository.findCustomByTravelAgency_IdAndTitleContainingAndCreatedAtBetweenOrderById(tripUserPrincipal.travelAgencyId(),input, dateTime, dateTime2, pageable);
                    } else {    //여행사 이름으로 검색 시
                        return admTravelAgencyListRepository.findCustomByTravelAgency_IdAndTravelAgencyNameContainingAndCreatedAtBetweenOrderById(tripUserPrincipal.travelAgencyId() , input, dateTime, dateTime2, pageable);
                    }
                }
                //출발일 기준
            } else {
                if (input == null || input.isBlank()) {
                    return admTravelAgencyListRepository.findCustomByTravelAgency_IdAndTravelRealTripAtBetweenOrderById(tripUserPrincipal.travelAgencyId(), startAt.replaceAll("-", ""), endAt.replaceAll("-", ""), pageable);
                } else {
                    if (inputSearch.toString().equals("TITLE")) {
                        return admTravelAgencyListRepository.findCustomByTravelAgency_IdAndTitleContainingAndTravelRealTripAtBetweenOrderById(tripUserPrincipal.travelAgencyId(),input, startAt.replaceAll("-", ""), endAt.replaceAll("-", ""), pageable);
                    } else {
                        return admTravelAgencyListRepository.findCustomByTravelAgency_IdAndTravelAgencyNameContainingAndTravelRealTripAtBetweenOrderById(tripUserPrincipal.travelAgencyId(),input, startAt.replaceAll("-", ""), endAt.replaceAll("-", ""), pageable);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTravelAgencyList(Long travelAgencyListId) {
        //TODO: 여행리스트 삭제시 결제 내역 체크 후 취소를 막아야 될까??... 현재 그냥 삭제되게 해놓음

        TravelAgencyList travelAgencyList = admTravelAgencyListRepository.findByIdAndDeleted(travelAgencyListId,false).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_AGENCY_LIST_NOT_FOUND));
        travelAgencyList.setDeleted(true);
    }

    @Transactional
    public void reDeleteTravelAgencyList(Long travelAgencyListId) {
        //TODO: 여행리스트 삭제시 결제 내역 체크 후 취소를 막아야 될까??... 현재 그냥 삭제되게 해놓음

        TravelAgencyList travelAgencyList = admTravelAgencyListRepository.findByIdAndDeleted(travelAgencyListId,true).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_AGENCY_LIST_NOT_FOUND));
        travelAgencyList.setDeleted(false);
    }

    @Transactional
    public void saveTravelAgencyList(TravelAgencyListDto dto){
        TravelAgency travelAgency = admTravelAgencyRepository.getReferenceById(dto.travel_agency_id());
        admTravelAgencyListRepository.save(dto.toEntity(travelAgency));
    }

    @Transactional
    public TravelAgencyListDto travelAgencyListDetail(Long travelAgencyListId , TripUserPrincipal tripUserPrincipal){
        if(tripUserPrincipal.role().equals("SUPER")) {
            var travelAgencyListDetail = admTravelAgencyListRepository.findById(travelAgencyListId).orElseThrow(() -> new BoardSiteException(ErrorCode.TRAVEL_AGENCY_DETAIL_NOT_FOUND));

            return Optional.of(travelAgencyListDetail).map(TravelAgencyListDto::from).orElseThrow(() -> new BoardSiteException(ErrorCode.TRAVEL_AGENCY_LIST_NOT_FOUND));
        } else {
            var travelAgencyListDetail = admTravelAgencyListRepository.findById(travelAgencyListId).orElseThrow(() -> new BoardSiteException(ErrorCode.TRAVEL_AGENCY_DETAIL_NOT_FOUND));
            if(!travelAgencyListDetail.getTravelAgency().getId().equals(tripUserPrincipal.travelAgencyId())){
                throw new BoardSiteException(ErrorCode.NOT_PERMITTION);
            }

            return Optional.of(travelAgencyListDetail).map(TravelAgencyListDto::from).orElseThrow(() -> new BoardSiteException(ErrorCode.TRAVEL_AGENCY_LIST_NOT_FOUND));

        }
    }


    @Transactional
    public void updateTravelAgencyList(Long TravelAgencyListId , TravelAgencyListDto dto){

        TravelAgencyList travelAgencyList = admTravelAgencyListRepository.findById(TravelAgencyListId).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_AGENCY_LIST_NOT_FOUND));
        TravelAgency travelAgency = admTravelAgencyRepository.findById(dto.travel_agency_id()).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_AGENCY_LIST_NOT_FOUND));
        travelAgencyList.setTravelAgency(travelAgency);
        travelAgencyList.setCity(dto.city());
        travelAgencyList.setContent(dto.content());
        travelAgencyList.setPersonMaxCount(dto.person_max_count());
        travelAgencyList.setRealPaid(dto.real_paid());
        travelAgencyList.setSalePaid(dto.sale_paid());
        travelAgencyList.setSalePercent(dto.sale_percent());
        travelAgencyList.setTitle(dto.title());
        travelAgencyList.setTravelEndAt(dto.travel_end_at());
        travelAgencyList.setTravelRealTripAt(dto.travelRealTripAt());
        travelAgencyList.setThumnbnailFileId(dto.thumnbnailFileId());
    }

    @Transactional
    public void sortTravelAgencyList(Long travelAgencyListId , int sort){
        if(sort==0) {
            var newTravelAgencyList =  admTravelAgencyListRepository.findById(travelAgencyListId).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_AGENCY_DETAIL_NOT_FOUND));
            newTravelAgencyList.setSort(null);
        } else {
            var oldTravelAgencyList =  admTravelAgencyListRepository.findBySort(sort);
            oldTravelAgencyList.ifPresent(travelAgencyList ->
            {
                travelAgencyList.setSort(null);
            });

            var newTravelAgencyList =  admTravelAgencyListRepository.findById(travelAgencyListId).orElseThrow(()->new BoardSiteException(ErrorCode.TRAVEL_AGENCY_DETAIL_NOT_FOUND));
            newTravelAgencyList.setSort(sort);
        }
    }



    @Transactional(readOnly = true)
    public  Page<TravelAgencyListDto> qrcodeTravelAgencyTripList(String startAt,
                                                                 String endAt,
                                                                 TripUserPrincipal tripUserPrincipal,
                                                                 Pageable pageable) {

        if(tripUserPrincipal.role().equals("SUPER")) {
            return admTravelAgencyListRepository.findByTravelRealTripAtBetweenOrderById(startAt.replaceAll("-", ""), endAt.replaceAll("-", ""), pageable).map(TravelAgencyListDto::from);
        }else {
            return admTravelAgencyListRepository.findByTravelAgency_IdAndTravelRealTripAtBetweenOrderById(tripUserPrincipal.travelAgencyId(), startAt.replaceAll("-", ""), endAt.replaceAll("-", ""), pageable).map(TravelAgencyListDto::from);

        }
    }

    @Transactional
    public TravelAgencyListDto qrcodeTravelAgencyListDetail(Long travelAgencyListId , TripUserPrincipal tripUserPrincipal){
        var date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        if(tripUserPrincipal.role().equals("SUPER")) {
            var travelAgencyListDetail = admTravelAgencyListRepository.findByIdAndTravelRealTripAtBetweenAndDeleted(travelAgencyListId,date,date,false).orElseThrow(() -> new BoardSiteException(ErrorCode.TRAVEL_AGENCY_LIST_DATE));
            return Optional.of(travelAgencyListDetail).map(TravelAgencyListDto::from).orElseThrow(() -> new BoardSiteException(ErrorCode.TRAVEL_AGENCY_LIST_NOT_FOUND));
        } else {
            var travelAgencyListDetail = admTravelAgencyListRepository.findByIdAndTravelRealTripAtBetweenAndDeleted(travelAgencyListId,date,date,false).orElseThrow(() -> new BoardSiteException(ErrorCode.TRAVEL_AGENCY_LIST_DATE));
            if(!travelAgencyListDetail.getTravelAgency().getId().equals(tripUserPrincipal.travelAgencyId())){
                throw new BoardSiteException(ErrorCode.NOT_PERMITTION);
            }

            return Optional.of(travelAgencyListDetail).map(TravelAgencyListDto::from).orElseThrow(() -> new BoardSiteException(ErrorCode.TRAVEL_AGENCY_LIST_NOT_FOUND));
        }
    }
    @Transactional(readOnly = true)
    public Page<AdmTravelAgencyReservationDto> qrcodeTravelUserList(Long travelAgencyListId , Pageable pageable) {
        return admTravelAgencyReservationRepository.findByTravelAgencyList_IdAndDeleted(travelAgencyListId , false,pageable).map(AdmTravelAgencyReservationDto::from);
    }

    @Transactional
    public void qrcodeUserUpd(QrcodeUserUpdateRequest qrcodeUserUpdateRequest) {
        if(!tripUserRepository.findById(qrcodeUserUpdateRequest.userId()).isPresent()) {
            throw new BoardSiteException(ErrorCode.USER_NOT_FOUND);
        }
        var reservation = admTravelAgencyReservationRepository.findById(qrcodeUserUpdateRequest.id()).orElseThrow(()-> new BoardSiteException(ErrorCode.NOT_TRAVEL_AGENCY_RESERVATION));
        if(reservation.getPersonCount() != qrcodeUserUpdateRequest.count()) {
            throw new BoardSiteException(ErrorCode.NOT_TRAVEL_AGENCY_RESERVATION);
        }
        if(reservation.getTripUser().getId() != qrcodeUserUpdateRequest.userId()) {
            throw new BoardSiteException(ErrorCode.NOT_TRAVEL_AGENCY_RESERVATION);
        }
        if(reservation.getTravelAgencyList().getId() != qrcodeUserUpdateRequest.travelAgencyListId()) {
            throw new BoardSiteException(ErrorCode.NOT_TRAVEL_AGENCY_RESERVATION);
        }
        reservation.setQrChk(true);


    }


}