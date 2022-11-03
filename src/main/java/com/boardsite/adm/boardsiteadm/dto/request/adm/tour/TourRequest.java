package com.boardsite.adm.boardsiteadm.dto.request.adm.tour;


import com.boardsite.adm.boardsiteadm.dto.tour.TourDto;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;

public record TourRequest(
        String title,
        String content,
        Long thumbnailId,
        String city
) {
    public static TourRequest of(String title,
                       String content,
                       Long thumbnailId,
                       String city) {
        return new TourRequest(title,
                content,
                thumbnailId,
                city);
    }

    public TourDto toDto(TripUserDto tripUserDto) {
        return TourDto.of(
                tripUserDto,
                title,
                content,
                thumbnailId,
                city
        );
    }
}
