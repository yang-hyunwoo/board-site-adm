package com.boardsite.adm.boardsiteadm.repository.user;

import com.boardsite.adm.boardsiteadm.domain.user.EmailAuth;
import com.boardsite.adm.boardsiteadm.repository.querydsl.user.EmailAuthCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmailAuthRepository extends JpaRepository<EmailAuth,Long>,
        EmailAuthCustomRepository {

    Optional<EmailAuth> findByEmail(String email);
}
