package com.boardsite.adm.boardsiteadm.service.chat;

import com.boardsite.adm.boardsiteadm.domain.chat.ChatRoomPerson;
import com.boardsite.adm.boardsiteadm.dto.chat.ChatRoomPersonDto;
import com.boardsite.adm.boardsiteadm.exception.BoardSiteException;
import com.boardsite.adm.boardsiteadm.exception.ErrorCode;
import com.boardsite.adm.boardsiteadm.repository.chat.ChatRepository;
import com.boardsite.adm.boardsiteadm.repository.chat.ChatRoomPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatRoomPersonService {

    private final ChatRoomPersonRepository chatRoomPersonRepository;

    private final ChatRepository chatRepository;

    @Transactional(readOnly = true)
    public ChatRoomPerson roomChk(Long id , Long UserId) {
        var chatRoomPerson = chatRoomPersonRepository.findByChatRoomIdAndTripUser_Id(id, UserId).orElseThrow(()->new BoardSiteException(ErrorCode.CHAT_ROOM_NOT_PERMISSION));
        return chatRoomPerson;
    }

    @Transactional(readOnly = true)
    public Integer roomUserChk(Long id , Long UserId) {
        var roomUserCount = chatRoomPersonRepository.findByChatRoomIdAndTripUser_Id(id, UserId).stream().toList();
        return roomUserCount.size();
    }

    @Transactional(readOnly = true)
    public List<ChatRoomPersonDto> roomPersonList(Long roomId){
        return chatRoomPersonRepository.findByChatRoom_IdOrderByCreatedBy(roomId).stream().map(ChatRoomPersonDto::from).collect(Collectors.toList());
    }

    @Transactional
    public void roomPersonDel(Long roomId , Long userId){
         chatRoomPersonRepository.delete(chatRoomPersonRepository.findByChatRoomIdAndTripUser_Id(roomId,userId).orElseThrow(()->new BoardSiteException(ErrorCode.CHAT_ROOM_NOT_FOUND)));
        var chatRoom = chatRepository.findById(roomId).orElseThrow(() -> new BoardSiteException(ErrorCode.CHAT_ROOM_NOT_FOUND));
                chatRoom.personCountMinus(chatRoom.getRoomPersonIngCount());

    }
}
