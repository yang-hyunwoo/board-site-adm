package com.boardsite.adm.boardsiteadm.repository.querydsl.user;

import com.boardsite.adm.boardsiteadm.domain.user.EmailAuth;

import java.time.LocalDateTime;
import java.util.Optional;

public interface EmailAuthCustomRepository {
    Optional<EmailAuth> findValidAuthByEmail(String email, String authToken, LocalDateTime currentTime);
}
