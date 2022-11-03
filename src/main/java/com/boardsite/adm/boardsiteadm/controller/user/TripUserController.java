package com.boardsite.adm.boardsiteadm.controller.user;


import com.boardsite.adm.boardsiteadm.dto.request.user.EmailAuthRequest;
import com.boardsite.adm.boardsiteadm.dto.request.user.TripUserJoinRequest;
import com.boardsite.adm.boardsiteadm.dto.request.user.TripUserLoginRequest;
import com.boardsite.adm.boardsiteadm.dto.request.user.TripUserUpdateRequest;
import com.boardsite.adm.boardsiteadm.dto.response.Response;
import com.boardsite.adm.boardsiteadm.dto.response.user.TripUserJoinResponse;
import com.boardsite.adm.boardsiteadm.dto.response.user.TripUserLoginResponse;
import com.boardsite.adm.boardsiteadm.dto.security.TripUserPrincipal;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;
import com.boardsite.adm.boardsiteadm.service.user.EmailService;
import com.boardsite.adm.boardsiteadm.service.user.TripUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/trip/users")
@RequiredArgsConstructor
@Slf4j
public class TripUserController {

    private final TripUserService tripUserService;

    private final EmailService emailService;

    /*
      사용자 / 관리자 회원가입 로직 동일
     */
    @PostMapping("/join")
    public Response<TripUserJoinResponse> join(@Valid @RequestBody TripUserJoinRequest request) {
        TripUserDto tripUserDto  = tripUserService.join(request.toDto());
        return Response.success(TripUserJoinResponse.from(tripUserDto));
    }



    @GetMapping("/confirm-email")
    public Response<String> confirmEmail(@ModelAttribute EmailAuthRequest request) {

           boolean test =  emailService.confirmEmail(request);

           if(test){
//               return Response.success("인증이 완료되었습니다.");
           } else {
               emailService.retryConfirmEmail(request);
//               return null;
           }
        return Response.success("인증이 완료되었습니다.");
    }

    /**
     * 로그인
     * @param request
     * @return
     */
    @PostMapping("/login")
    public Response<TripUserLoginResponse> login(@RequestBody TripUserLoginRequest request) {
        String token = tripUserService.login(request.email(),request.password());
        return Response.success(new TripUserLoginResponse(token));

    }

    /**
     * 마이페이지 데이터 조회
     * @param tripUserPrincipal
     * @return
     */
    @GetMapping("/my-page")
    public Response<TripUserDto> myPage(@AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {
        var myPage = tripUserService.myPage(tripUserPrincipal.id());
        return Response.success(myPage);
    }

    /**
     * 패스워드 변경
     * @param request
     * @param tripUserPrincipal
     * @return
     */
    @PostMapping("/change/password")
    public Response<Boolean> changePassword(@RequestBody TripUserLoginRequest request ,
                                            @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {
        tripUserService.changePassword(tripUserPrincipal.id(),request.password());
        return Response.success(true);
    }

    /**
     * 패스워드 제외 정보 수정
     * @param request
     * @param tripUserPrincipal
     * @return
     */
    @PostMapping("/change/other")
    public Response<Boolean> changeUserOther(@RequestBody TripUserUpdateRequest request ,
                                            @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {
        tripUserService.changeUserOther(tripUserPrincipal.id(),request.toDto());
        return Response.success(true);
    }

}
