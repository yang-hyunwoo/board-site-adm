package com.boardsite.adm.boardsiteadm.dto.travel;

import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgencyLike;
import com.boardsite.adm.boardsiteadm.domain.travel.TravelAgencyList;
import com.boardsite.adm.boardsiteadm.domain.user.TripUser;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;

import java.time.LocalDateTime;

public record TravelAgencyLikeDto(
        Long id,
        TripUserDto tripUser,
        TravelAgencyListDto travelAgencyList,
        boolean deleted,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static TravelAgencyLikeDto of(Long id,
                               TripUserDto tripUser,
                               TravelAgencyListDto travelAgencyList,
                               boolean deleted,
                               LocalDateTime createdAt,
                               String createdBy,
                               LocalDateTime modifiedAt,
                               String modifiedBy) {
        return new TravelAgencyLikeDto(
                id,
                tripUser,
                travelAgencyList,
                deleted,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy);
    }

    public static TravelAgencyLikeDto from(TravelAgencyLike entity) {
        return new TravelAgencyLikeDto(
                entity.getId(),
                TripUserDto.from(entity.getTripUser()),
                TravelAgencyListDto.from(entity.getTravelAgencyList()),
                entity.isDeleted(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public TravelAgencyLike toEntity(TripUser tripUser ,
                                     TravelAgencyList travelAgencyList) {
        return TravelAgencyLike.of(
                tripUser,
                travelAgencyList,
                deleted
        );
    }
}
