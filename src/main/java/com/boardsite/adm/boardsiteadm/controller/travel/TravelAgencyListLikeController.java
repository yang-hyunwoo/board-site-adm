package com.boardsite.adm.boardsiteadm.controller.travel;

import com.boardsite.adm.boardsiteadm.dto.response.Response;
import com.boardsite.adm.boardsiteadm.dto.response.travel.TravelAgencyLikeResponse;
import com.boardsite.adm.boardsiteadm.dto.security.TripUserPrincipal;
import com.boardsite.adm.boardsiteadm.service.travel.TravelAgencyListLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trip/like")
@RequiredArgsConstructor
public class TravelAgencyListLikeController {

    private final TravelAgencyListLikeService travelAgencyListLikeService;

    @GetMapping("/list")
    public Response<Page<TravelAgencyLikeResponse>> travelAgencyList(@PageableDefault(size=9,sort="createdAt",direction= Sort.Direction.DESC) Pageable pageable,
                                                                     @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal){
       var pageTravel = travelAgencyListLikeService.travelAgencyLikeList(tripUserPrincipal.id(), pageable).map(TravelAgencyLikeResponse::from);
        return Response.success(pageTravel);
    }
}
