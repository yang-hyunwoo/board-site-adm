package com.boardsite.adm.boardsiteadm.dto.user;

import com.boardsite.adm.boardsiteadm.domain.user.EmailAuth;

import java.time.LocalDateTime;

public record EmailAuthDto(
        Long id,
        String email,
        String authToken,
        Boolean expired,
        LocalDateTime expireDate
) {

    public EmailAuth toEntity(){
        return EmailAuth.of(
                email,
                authToken,
                expired,
                expireDate
        );
    }

    public static EmailAuthDto of(
                        String email,
                        String authToken,
                        Boolean expired,
                        LocalDateTime expireDate)
    {
        return new EmailAuthDto(null,email,authToken,expired,expireDate);
    }
}
