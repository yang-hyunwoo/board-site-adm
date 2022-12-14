package com.boardsite.adm.boardsiteadm.dto.travel;

import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgency;

import java.util.List;

public record TravelAgencyWithTravelAgencyListDto(
        Long id,
        String name,
        String detail,
        String comment,
        String address,
        String tel,
        List<TravelAgencyListDto> travelAgencyListDtos
) {

    public static TravelAgencyWithTravelAgencyListDto of(Long id,
                                               String name,
                                               String detail,
                                               String comment,
                                               String address,
                                               String tel,
                                                         List<TravelAgencyListDto> travelAgencyListDtos) {
        return new TravelAgencyWithTravelAgencyListDto(
                id,
                name,
                detail,
                comment,
                address,
                tel,
                travelAgencyListDtos);
    }

    public static TravelAgencyWithTravelAgencyListDto from(TravelAgency entity){
        return new TravelAgencyWithTravelAgencyListDto(
                entity.getId(),
                entity.getName(),
                entity.getDetail(),
                entity.getComment(),
                entity.getAddress(),
                entity.getTel(),
                entity.getTravelAgencyLists().stream()
                        .map(TravelAgencyListDto::from)
                        .toList()

        );
    }

}
