package com.boardsite.adm.boardsiteadm.service.adm.auth;

import com.boardsite.adm.boardsiteadm.dto.response.adm.auth.AdmUserDto;
import com.boardsite.adm.boardsiteadm.exception.BoardSiteException;
import com.boardsite.adm.boardsiteadm.exception.ErrorCode;
import com.boardsite.adm.boardsiteadm.repository.user.TripUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdmAuthService {


    private final TripUserRepository tripUserRepository;



    @Transactional(readOnly = true)
    public PageImpl<AdmUserDto> userList(String searchKeyWord, Pageable pageable) {

        if (searchKeyWord == null || searchKeyWord.isBlank()) {
            return tripUserRepository.findUser("ADMIN",pageable);
        }else {
           return tripUserRepository.findUserEmailContaining("ADMIN", searchKeyWord, pageable);
        }
    }

    @Transactional
    public void acceptAdmin(Long adminId) {
        var tripUser = tripUserRepository.findByIdAndAuthChk(adminId,false).orElseThrow(()->new BoardSiteException(ErrorCode.USER_NOT_FOUND));
            tripUser.setAuthChk(!tripUser.isAuthChk());
            tripUserRepository.saveAndFlush(tripUser);
    }

    @Transactional
    public void reAcceptAdmin(Long adminId) {
        var tripUser = tripUserRepository.findByIdAndAuthChk(adminId,true).orElseThrow(()->new BoardSiteException(ErrorCode.USER_NOT_FOUND));
        tripUser.setAuthChk(!tripUser.isAuthChk());
        tripUserRepository.saveAndFlush(tripUser);
    }


}
