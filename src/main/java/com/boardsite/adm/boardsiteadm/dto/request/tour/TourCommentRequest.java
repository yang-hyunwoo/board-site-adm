package com.boardsite.adm.boardsiteadm.dto.request.tour;


import com.boardsite.adm.boardsiteadm.dto.tour.TourCommentDto;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;

public record TourCommentRequest(
        Long tourId,
        String content
)
{
    public static TourCommentRequest of(Long tourId, String content) {
        return new TourCommentRequest(tourId,content);
    }

    public TourCommentDto toDto(TripUserDto tripUserDto){
        return TourCommentDto.of(
                tourId,
                tripUserDto,
                content
        );
    }
}
