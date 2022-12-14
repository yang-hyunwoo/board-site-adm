package com.boardsite.adm.boardsiteadm.dto.tour;




import com.boardsite.adm.boardsiteadm.domain.tour.Tour;
import com.boardsite.adm.boardsiteadm.domain.user.TripUser;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;

import java.time.LocalDateTime;

public record TourDto(
        Long id,
        TripUserDto tripUser,
        String title,
        String content,
        boolean deleted,
        int readCount,
        Long thumbnailId,
        String filePath,
        String city,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
)
{
    public static TourDto of(
            TripUserDto tripUser,
            String title,
            String content,
            Long thumbnailId,
            String city) {
        return new TourDto(null,
                tripUser,
                title,
                content,
                false,
                0,
                thumbnailId,
                null,
                city,
                null,
                null,
                null,
                null);
    }

    public static TourDto of(Long id,
                             TripUserDto tripUser,
                             String title,
                             String content,
                             boolean deleted,
                             int readCount,
                             Long thumbnailId,
                             String filePath,
                             String city,
                             LocalDateTime createdAt,
                             String createdBy,
                             LocalDateTime modifiedAt,
                             String modifiedBy) {
        return new TourDto(id,
                tripUser,
                title,
                content,
                deleted,
                readCount,
                thumbnailId,
                filePath,
                city,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy);
    }

    public static TourDto from(Tour entity){
        return new TourDto(
                entity.getId(),
                TripUserDto.from(entity.getTripUser()),
                entity.getTitle(),
                entity.getContent(),
                entity.isDeleted(),
                entity.getReadCount(),
                entity.getThumbnailId(),
                null,
                entity.getCity(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public Tour toEntity(TripUser tripUser) {
        return Tour.of(
                title,
                content,
                deleted,
                readCount,
                city,
                thumbnailId,
                tripUser
        );
    }
}
