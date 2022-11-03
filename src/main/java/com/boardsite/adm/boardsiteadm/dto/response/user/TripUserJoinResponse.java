package com.boardsite.adm.boardsiteadm.dto.response.user;


import com.boardsite.adm.boardsiteadm.domain.constant.Gender;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;

public record TripUserJoinResponse(
        Long id,
        String name,
        String nickName,
        String email,
        String phoneNumber,
        int point,
        Gender gender
    )
{
    public static TripUserJoinResponse of(Long id,
                                          String name,
                                          String nickName,
                                          String email,
                                          String phoneNumber,
                                          int point,
                                          Gender gender) {
        return new TripUserJoinResponse(id,
                name,
                nickName,
                email,
                phoneNumber,
                point,
                gender);
    }
    public static TripUserJoinResponse from(TripUserDto dto) {
        return new TripUserJoinResponse(
                dto.id(),
                dto.name(),
                dto.nickName(),
                dto.email(),
                dto.phoneNumber(),
                dto.point(),
                dto.gender()
        );
    }

}
