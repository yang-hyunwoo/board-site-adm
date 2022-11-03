package com.boardsite.adm.boardsiteadm.repository.querydsl.user;

import com.boardsite.adm.boardsiteadm.dto.response.adm.auth.AdmUserDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface AdmAuthCustomRepository {

    PageImpl<AdmUserDto> findUser(String auth , Pageable pageable);

    PageImpl<AdmUserDto> findUserEmailContaining(String auth ,String email, Pageable pageable);

}
