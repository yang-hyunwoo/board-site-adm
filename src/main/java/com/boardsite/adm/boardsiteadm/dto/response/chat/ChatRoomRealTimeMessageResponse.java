package com.boardsite.adm.boardsiteadm.dto.response.chat;



import com.boardsite.adm.boardsiteadm.dto.chat.ChatRoomMessageDto;

import java.time.LocalDateTime;

public record ChatRoomRealTimeMessageResponse(
        Long id,
        LocalDateTime createdAt,
        String content,
        Long chatRoomId,
        Long userId,
        String nickName,
        Long profileId
) {
    public static ChatRoomRealTimeMessageResponse of(Long id,
                                                     LocalDateTime createdAt,
                                                     String content,
                                                     Long chatRoomId,
                                                     Long userId,
                                                     String nickName,
                                                     Long profileId) {
        return new ChatRoomRealTimeMessageResponse(
                id,
                createdAt,
                content,
                chatRoomId,
                userId,
                nickName,
                profileId);
    }

    public static ChatRoomRealTimeMessageResponse from(ChatRoomMessageDto dto){
        return new ChatRoomRealTimeMessageResponse(
                dto.id(),
                dto.createdAt(),
                dto.content(),
                dto.chatRoomId(),
                dto.tripUser().id(),
                dto.tripUser().nickName(),
                dto.tripUser().profileId()
        );
    }

}
