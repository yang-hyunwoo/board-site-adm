package com.boardsite.adm.boardsiteadm.dto.chat;

import com.boardsite.adm.boardsiteadm.domain.chat.ChatRoomMessage;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;

import java.time.LocalDateTime;

public record ChatRoomMessageDto(
        Long id,
        Long chatRoomId,
        TripUserDto tripUser,
        String content,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static ChatRoomMessageDto of(Long id,
                              Long chatRoom,
                              TripUserDto tripUser,
                              String content,
                              LocalDateTime createdAt,
                              String createdBy,
                              LocalDateTime modifiedAt,
                              String modifiedBy) {
        return new ChatRoomMessageDto(
                id,
                chatRoom,
                tripUser,
                content,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy);
    }

    public static ChatRoomMessageDto of(Long chatRoom,
                                        TripUserDto tripUser,
                                        String content
    ) {
        return new ChatRoomMessageDto(null,
                chatRoom,
                tripUser,
                content,
                null,
                null,
                null,
                null);
    }

    public static ChatRoomMessageDto from(ChatRoomMessage entity) {
        return new ChatRoomMessageDto(
                entity.getId(),
                entity.getChatRoom().getId(),
                TripUserDto.from(entity.getTripUser()),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

}
