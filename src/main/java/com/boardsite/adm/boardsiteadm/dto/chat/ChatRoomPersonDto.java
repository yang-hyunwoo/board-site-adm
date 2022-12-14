package com.boardsite.adm.boardsiteadm.dto.chat;


import com.boardsite.adm.boardsiteadm.domain.chat.ChatRoom;
import com.boardsite.adm.boardsiteadm.domain.chat.ChatRoomPerson;
import com.boardsite.adm.boardsiteadm.domain.user.TripUser;
import com.boardsite.adm.boardsiteadm.dto.user.TripUserDto;

public record ChatRoomPersonDto(
        Long id,
        ChatRoomDto chatRoom,
        TripUserDto tripUser
)  {
    public static ChatRoomPersonDto of(Long id,
                             ChatRoomDto chatRoom,
                             TripUserDto tripUser) {
        return new ChatRoomPersonDto(
                id,
                chatRoom,
                tripUser
        );
    }

    public static ChatRoomPersonDto of(
                                       ChatRoomDto chatRoom,
                                       TripUserDto tripUser) {
        return new ChatRoomPersonDto(
                null,
                chatRoom,
                tripUser
        );
    }

    public static ChatRoomPersonDto from(ChatRoomPerson entity){
        return new ChatRoomPersonDto(
                entity.getId(),
                ChatRoomDto.from(entity.getChatRoom()),
                TripUserDto.from(entity.getTripUser())
        );
    }
    public ChatRoomPerson toEntity(ChatRoom chatRoom , TripUser tripUser){
        return ChatRoomPerson.of(chatRoom, tripUser);
    }
}
