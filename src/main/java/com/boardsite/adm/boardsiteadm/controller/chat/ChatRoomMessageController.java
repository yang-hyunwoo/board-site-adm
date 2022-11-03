package com.boardsite.adm.boardsiteadm.controller.chat;


import com.boardsite.adm.boardsiteadm.dto.response.Response;
import com.boardsite.adm.boardsiteadm.dto.response.chat.ChatRoomMessageResponse;
import com.boardsite.adm.boardsiteadm.dto.security.TripUserPrincipal;
import com.boardsite.adm.boardsiteadm.service.chat.ChatRoomMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chat/detail")
@RequiredArgsConstructor
public class ChatRoomMessageController {

    private final ChatRoomMessageService chatRoomMessageService;

    @GetMapping("/rooms/{roomId}")
    public Response<List<ChatRoomMessageResponse>> roomEnterAndMessage(@PathVariable Long roomId,
                                                                       @AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {
       var chatRoomMessageResponse = chatRoomMessageService.roomMessage(roomId,tripUserPrincipal.id()).stream().map(ChatRoomMessageResponse::from).collect(Collectors.toList());
        return Response.success(chatRoomMessageResponse);
    }

    @GetMapping("/rooms/chk")
    public Response<Long> roomTripUserId(@AuthenticationPrincipal TripUserPrincipal tripUserPrincipal) {
        return Response.success(tripUserPrincipal.id());
    }

}
