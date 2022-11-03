package com.boardsite.adm.boardsiteadm.dto.request.user;

public record EmailAuthRequest(
        String email,
        String authToken,
        Boolean expired
) {
}
