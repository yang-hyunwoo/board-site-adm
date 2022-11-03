package com.boardsite.adm.boardsiteadm.service.user;

import com.boardsite.adm.boardsiteadm.domain.user.TripUser;
import com.boardsite.adm.boardsiteadm.dto.security.TripUserPrincipal;
import com.boardsite.adm.boardsiteadm.dto.user.EmailAuthDto;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;
import com.boardsite.adm.boardsiteadm.exception.BoardSiteException;
import com.boardsite.adm.boardsiteadm.exception.ErrorCode;
import com.boardsite.adm.boardsiteadm.repository.user.EmailAuthRepository;
import com.boardsite.adm.boardsiteadm.repository.user.TripUserRepository;
import com.boardsite.adm.boardsiteadm.support.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TripUserService {

    private final TripUserRepository tripUserRepository;
    private final EmailAuthRepository emailAuthRepository;
    private final BCryptPasswordEncoder encoder;
    private final EmailService emailService;

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.token.expired-time-ms}")
    private Long expiredTimeMs;

    public TripUserPrincipal loadUserByEmail(String email) {
        return  tripUserRepository.findByEmail(email)
                .map(TripUserDto::from)
                .map(TripUserPrincipal::from)
                .orElseThrow(() -> new BoardSiteException(ErrorCode.USER_NOT_FOUND,String.format("%s not founded",email)));

    }

    public TripUserPrincipal loadUserById(Long id) {
        return  tripUserRepository.findById(id)
                .map(TripUserDto::from)
                .map(TripUserPrincipal::from)
                .orElseThrow(() -> new BoardSiteException(ErrorCode.USER_NOT_FOUND,String.format("%users not founded")));

    }

    @Transactional
    public TripUserDto join(TripUserDto tripUserDto) {
        tripUserRepository.findByEmailAndLoginType(tripUserDto.email().trim(),tripUserDto.loginType()).ifPresent(it -> {
            throw new BoardSiteException(ErrorCode.DUPLICATED_EMAIL, String.format("%s is duplicated", tripUserDto.email()));
        });

        String passwordEncode = encoder.encode(tripUserDto.password());
        TripUser tripUser = tripUserRepository.save(tripUserDto.toEntity(passwordEncode));
      if(tripUserDto.loginType()==null) {
          EmailAuthDto emailAuthDto = EmailAuthDto.of(tripUserDto.email(), UUID.randomUUID().toString(), false, LocalDateTime.now());
          emailAuthRepository.save(emailAuthDto.toEntity());
          emailService.send(emailAuthDto.email(), emailAuthDto.authToken());
      }


        return TripUserDto.from(tripUser);
    }

    public String login(String email , String password) {
        var tripUser = tripUserRepository.findByEmailAndEmailAuthAndDeletedAndLoginTypeIsNull(email,true,false).orElseThrow(() -> new BoardSiteException(ErrorCode.EMAIL_NOT_FOUND,String.format("%s not founded2222",email)));
        if(!encoder.matches(password , tripUser.getPassword())) {
            throw new BoardSiteException(ErrorCode.INVALID_PASSWORD);
        }
        String token = JwtTokenUtils.generateToken(email,secretKey ,tripUser.getRole(), tripUser.getId(), tripUser.getTravelAgencyId(),expiredTimeMs);

        return token;
    }

    public String snsLogin(String email,String loginType) {
        var tripUser = tripUserRepository.findByEmailAndDeletedAndLoginType(email,false,loginType).orElseThrow(() -> new BoardSiteException(ErrorCode.EMAIL_NOT_FOUND,String.format("%s not founded3333",email)));

        String token = JwtTokenUtils.generateToken(email,secretKey ,tripUser.getRole(),tripUser.getId(), tripUser.getTravelAgencyId(),expiredTimeMs);

        return token;
    }



    @Transactional(readOnly = true)
    public TripUserDto myPage(Long tripUserId) {
        var tripUser = tripUserRepository.findById(tripUserId).orElseThrow(()->new BoardSiteException(ErrorCode.USER_NOT_FOUND));

        return TripUserDto.from(tripUser);
    }

    @Transactional
    public void changePassword(Long tripUserId , String password) {
        var tripUser = tripUserRepository.findById(tripUserId).orElseThrow(()->new BoardSiteException(ErrorCode.USER_NOT_FOUND));
        String passwordEncode = encoder.encode(password);
        tripUser.setPassword(passwordEncode);
    }

    @Transactional
    public void changeUserOther(Long tripUserId , TripUserDto tripUserDto) {
        var tripUser = tripUserRepository.findById(tripUserId).orElseThrow(()->new BoardSiteException(ErrorCode.USER_NOT_FOUND));

        tripUserRepository.findByNickName(tripUserDto.nickName().trim()).ifPresent(it -> {
            throw new BoardSiteException(ErrorCode.DUPLICATED_NICKNAME, String.format("%s is duplicated", tripUserDto.nickName()));
        });

        tripUser.setProfileId(tripUserDto.profileId());
        tripUser.setNickName(tripUserDto.nickName());
        tripUser.setGender(tripUserDto.gender());
        tripUser.setPhoneNumber(tripUserDto.phoneNumber());
    }

}