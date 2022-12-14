package com.boardsite.adm.boardsiteadm.dto.response.travel;

import com.boardsite.adm.boardsiteadm.dto.travel.TravelAgencyWithTravelAgencyListDto;

import java.util.List;

public record TravelAgencyWithTravelAgencyListResponse(
        Long id,
        String name,
        String detail,
        String comment,
        String address,
        String tel,
        List<TravelAgencyListResponse> travelAgencyListResponse
) {
    public static TravelAgencyWithTravelAgencyListResponse of(Long id,
                                                    String name,
                                                    String detail,
                                                    String comment,
                                                    String address,
                                                    String tel,
                                                    List<TravelAgencyListResponse> travelAgencyListResponse) {
        return new TravelAgencyWithTravelAgencyListResponse(
                id,
                name,
                detail,
                comment,
                address,
                tel,
                travelAgencyListResponse);
    }

    public static TravelAgencyWithTravelAgencyListResponse from(TravelAgencyWithTravelAgencyListDto dto){
        return new TravelAgencyWithTravelAgencyListResponse(
                dto.id(),
                dto.name(),
                dto.detail(),
                dto.comment(),
                dto.address(),
                dto.tel(),
                dto.travelAgencyListDtos().stream()
                        .map(TravelAgencyListResponse::from)
                        .toList()
        );
    }
}
