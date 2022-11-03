package com.boardsite.adm.boardsiteadm.controller.adm.travel;


import com.boardsite.adm.boardsiteadm.dto.response.Response;
import com.boardsite.adm.boardsiteadm.dto.response.adm.travel.AdmTravelAgencyReservationResponse;
import com.boardsite.adm.boardsiteadm.dto.security.TripUserPrincipal;
import com.boardsite.adm.boardsiteadm.service.adm.travel.AdmTravelAgencyReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * 여행 결제 및 조회 클래스
 * @author cohouseol
 */

@RestController
@RequestMapping("/api/adm/reser")
@RequiredArgsConstructor
public class AdmTravelAgencyReservationController {

    private final AdmTravelAgencyReservationService admTravelAgencyReservationService;

    @GetMapping("/{travelAgencyListId}/purchaseList")
    public Response<Page<AdmTravelAgencyReservationResponse>> getReservationList(@PathVariable Long travelAgencyListId,
                                                                                 @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal,
                                                                                 @PageableDefault(size=10,sort="createdAt",direction= Sort.Direction.DESC)Pageable pageable) {

        var response = admTravelAgencyReservationService.getReservationList(travelAgencyListId,tripUserPrincipal.travelAgencyId(),tripUserPrincipal.role() , pageable).map(AdmTravelAgencyReservationResponse::from);
        return Response.success(response);
    }


//    @PostMapping("/pay/complete")
//    public Response<Boolean> savePaymentTravelAgency(@RequestBody TravelAgencyReservationRequest travelAgencyReservationRequest,
//                                                     @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {
//        boolean chk =  travelAgencyReservationService.travelAgencyReserSave(travelAgencyReservationRequest.toDto(tripUserPrincipal.toDto()));
//        return Response.success(chk);
//    }
//
//
//
//    @PostMapping("/pay/refund")
//    public Response<Boolean> payRefund(@RequestBody TravelAgencyRerservationRefundRequest travelAgencyRerservationRefundRequest) throws ParseException {
//        boolean chk = travelAgencyReservationService.iamPortRefund(travelAgencyRerservationRefundRequest);
//        return Response.success(chk);
//    }



}
