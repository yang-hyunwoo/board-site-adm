package com.boardsite.adm.boardsiteadm.dto.request.user;


import com.boardsite.adm.boardsiteadm.domain.constant.Gender;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;

public record TripUserUpdateRequest(
        String nickName,
        String phoneNumber,
        Gender gender ,
        Long profileId,
        String role,
        String loginType,
        Long travelAgencyId
)  {
    public static TripUserUpdateRequest of(String nickName,
                                           String phoneNumber,
                                           Gender gender,
                                           Long profileId,
                                           String role,
                                           String loginType,
                                           Long travelAgencyId) {
        return new TripUserUpdateRequest(
            nickName,phoneNumber,gender,profileId,role,loginType,travelAgencyId
        );
    }

    public TripUserDto toDto(){
        return TripUserDto.of(
                nickName,
                phoneNumber,
                gender,
                profileId,
                role,
                loginType,
                travelAgencyId
        );
    }
}
