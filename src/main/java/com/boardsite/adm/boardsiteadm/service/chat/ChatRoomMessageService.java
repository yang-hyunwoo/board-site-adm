package com.boardsite.adm.boardsiteadm.service.chat;

import com.boardsite.adm.boardsiteadm.domain.chat.ChatRoomMessage;
import com.boardsite.adm.boardsiteadm.dto.chat.ChatRoomMessageDto;
import com.boardsite.adm.boardsiteadm.exception.BoardSiteException;
import com.boardsite.adm.boardsiteadm.exception.ErrorCode;
import com.boardsite.adm.boardsiteadm.repository.chat.ChatRepository;
import com.boardsite.adm.boardsiteadm.repository.chat.ChatRoomMessageRepository;
import com.boardsite.adm.boardsiteadm.repository.user.TripUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatRoomMessageService {

    private final ChatRoomMessageRepository chatRoomMessageRepository;

    private final ChatRepository chatRepository;
    private final ChatRoomPersonService chatRoomPersonService;

    private final TripUserRepository tripUserRepository;
    @Transactional(readOnly = true)
    public List<ChatRoomMessageDto> roomMessage(Long id , Long UserId) {
       var chatRoomPerson = chatRoomPersonService.roomChk(id, UserId);
       chatRoomPerson.getCreatedAt();
        return  chatRoomMessageRepository.findByChatRoom_IdAndCreatedAtAfterOrderByCreatedAtAsc(chatRoomPerson.getChatRoom().getId(),chatRoomPerson.getCreatedAt()).stream().map(ChatRoomMessageDto::from).collect(Collectors.toList());
    }

    @Transactional
    public ChatRoomMessageDto roomMessageSave(Long id , Long userId ,String content){
        var tripUser = tripUserRepository.getReferenceById(userId);
        var chatRoom = chatRepository.findById(id).orElseThrow(() -> new BoardSiteException(ErrorCode.CHAT_ROOM_NOT_FOUND));

        var chatRoomMessage = ChatRoomMessage.of(chatRoom,tripUser,content);
        var chatRoomMessageId = chatRoomMessageRepository.save(chatRoomMessage).getId();
        return chatRoomMessageRepository.findById(chatRoomMessageId).map(ChatRoomMessageDto::from).orElseThrow(()->new BoardSiteException(ErrorCode.CHAT_ROOM_NOT_FOUND));
    }
}
