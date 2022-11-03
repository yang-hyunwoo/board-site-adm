package com.boardsite.adm.boardsiteadm.repository.user;

import com.boardsite.adm.boardsiteadm.domain.user.TripUser;
import com.boardsite.adm.boardsiteadm.repository.querydsl.user.AdmAuthCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TripUserRepository extends JpaRepository<TripUser, Long>, AdmAuthCustomRepository {

    Optional<TripUser> findByEmail(String email);

    Optional<TripUser> findByEmailAndLoginType(String email,String loginType);

    Optional<TripUser> findByNickName(String nickName);

    Optional<TripUser> findByEmailAndEmailAuthAndDeletedAndLoginTypeIsNull(String email,boolean emailAuth,boolean deleted);

    Optional<TripUser> findByEmailAndEmailAuthAndDeletedAndAuthChk(String email,boolean emailAuth,boolean deleted,boolean authChk);

    Optional<TripUser> findByEmailAndDeletedAndLoginType(String email,boolean deleted,String loginType);



    Optional<TripUser> findByIdAndAuthChk(Long adminId , boolean authChk);



}
