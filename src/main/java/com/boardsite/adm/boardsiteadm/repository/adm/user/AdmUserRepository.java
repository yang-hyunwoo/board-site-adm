package com.boardsite.adm.boardsiteadm.repository.adm.user;

import com.boardsite.adm.boardsiteadm.domain.user.TripUser;
import com.boardsite.adm.boardsiteadm.repository.querydsl.user.AdmUserCustomRepository;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmUserRepository extends JpaRepository<TripUser, Long>, AdmUserCustomRepository {

    PageImpl<TripUser> findByRole(String role, Pageable pageable);

    PageImpl<TripUser> findByNameContainingAndRole(String input, String role, Pageable pageable);
    PageImpl<TripUser> findByEmailContainingAndRole(String input, String role, Pageable pageable);
    PageImpl<TripUser> findByNickNameContainingAndRole(String input, String role, Pageable pageable);


}
