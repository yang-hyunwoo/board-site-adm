package com.boardsite.adm.boardsiteadm.dto.request.user;


import com.boardsite.adm.boardsiteadm.domain.constant.Gender;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;

public record TripUserJoinRequest(
        String name,
        String nickName,
        String email,
        String password,
        String phoneNumber,
        Gender gender,
        Long travelAgencyId,
        String role,
        String loginType
)  {
    public static TripUserJoinRequest of(String name,
                                         String nickName,
                                         String email,
                                         String password,
                                         String phoneNumber,
                                         Gender gender,
                                         Long travelAgencyId,
                                         String role,
                                         String loginType) {
        return new TripUserJoinRequest(
            name,nickName,email,password,phoneNumber,gender,travelAgencyId,role,loginType
        );
    }

    public TripUserDto toDto(){
        return TripUserDto.of(email,
                name,
                nickName,
                phoneNumber,
                password,
                gender,
                role,
                loginType,
                travelAgencyId
        );
    }
}
