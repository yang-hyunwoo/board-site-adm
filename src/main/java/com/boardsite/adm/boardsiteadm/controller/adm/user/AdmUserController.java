package com.boardsite.adm.boardsiteadm.controller.adm.user;


import com.boardsite.adm.boardsiteadm.domain.constant.SearchAdmUserType;
import com.boardsite.adm.boardsiteadm.dto.response.Response;
import com.boardsite.adm.boardsiteadm.dto.response.adm.auth.UserResponse;
import com.boardsite.adm.boardsiteadm.dto.response.adm.travel.AdmTravelAgencyReservationResponse;
import com.boardsite.adm.boardsiteadm.dto.security.TripUserPrincipal;
import com.boardsite.adm.boardsiteadm.service.adm.user.AdmUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  사용자 정보 컨트롤러
 *  @author cohouseol
 */
@RestController
@RequestMapping("/api/adm/user")
@RequiredArgsConstructor
public class AdmUserController {

    private final AdmUserService admUserService;

    /**
     * 사용자 정보 리스트 조회 (SUPER : 전체  / ADMIN : 결제한 사용자만)
     * @param searchAdmUserType
     * @param input
     * @param pageable
     * @param tripUserPrincipal
     * @return
     */
    @GetMapping("/list")
    public Response<Page<UserResponse>> userList(@RequestParam(required = false) SearchAdmUserType searchAdmUserType,
                                                 @RequestParam(required = false) String input,
                                                 @PageableDefault(size=10,sort="id",direction= Sort.Direction.ASC) Pageable pageable,
                                                 @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {
        var userList = admUserService.userList(searchAdmUserType,input,tripUserPrincipal,pageable).map(UserResponse::from);

        return Response.success(userList);
    }

    @GetMapping("/reser/list")
    public Response<Page<AdmTravelAgencyReservationResponse>> userPayList(@RequestParam(required = true) Long userId,
                                                                          @PageableDefault(size=10,sort="createdAt",direction= Sort.Direction.DESC) Pageable pageable,
                                                                          @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {

        var userPayList = admUserService.userPayList(userId,tripUserPrincipal,pageable).map(AdmTravelAgencyReservationResponse::from);
        return Response.success(userPayList);
    }

}
