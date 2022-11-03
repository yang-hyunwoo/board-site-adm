package com.boardsite.adm.boardsiteadm.controller.travel;

import com.boardsite.adm.boardsiteadm.dto.request.travel.TravelAgencyRerservationRefundRequest;
import com.boardsite.adm.boardsiteadm.dto.request.travel.TravelAgencyReservationRequest;
import com.boardsite.adm.boardsiteadm.dto.response.Response;
import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyReservationResponse;
import com.boardsite.adm.boardsiteadm.dto.security.TripUserPrincipal;
import com.boardsite.adm.boardsiteadm.service.travel.TravelAgencyReservationService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
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
@RequestMapping("/api/trip/reser")
@RequiredArgsConstructor
public class TravelAgencyReservationController {

    private final TravelAgencyReservationService travelAgencyReservationService;

    @PostMapping("/pay/complete")
    public Response<Boolean> savePaymentTravelAgency(@RequestBody TravelAgencyReservationRequest travelAgencyReservationRequest,
                                                     @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {
        boolean chk =  travelAgencyReservationService.travelAgencyReserSave(travelAgencyReservationRequest.toDto(tripUserPrincipal.toDto()));
        return Response.success(chk);
    }

    @GetMapping("/purchaseList")
    public Response<Page<TravelAgencyReservationResponse>> getReservationList(@AuthenticationPrincipal TripUserPrincipal tripUserPrincipal,
                                                                              @PageableDefault(size=10,sort="createdAt",direction= Sort.Direction.DESC)Pageable pageable) {

        var response = travelAgencyReservationService.getReservationList(tripUserPrincipal.id(),pageable).map(TravelAgencyReservationResponse::from);
        return Response.success(response);
    }

    @PostMapping("/pay/refund")
    public Response<Boolean> payRefund(@RequestBody TravelAgencyRerservationRefundRequest travelAgencyRerservationRefundRequest) throws ParseException {
        boolean chk = travelAgencyReservationService.iamPortRefund(travelAgencyRerservationRefundRequest);
        return Response.success(chk);
    }



}
