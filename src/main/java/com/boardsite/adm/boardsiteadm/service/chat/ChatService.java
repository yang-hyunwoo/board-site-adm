package com.boardsite.adm.boardsiteadm.service.chat;


import com.boardsite.adm.boardsiteadm.domain.chat.ChatRoomPerson;
import com.boardsite.adm.boardsiteadm.dto.chat.ChatRoomDto;
import com.boardsite.adm.boardsiteadm.exception.BoardSiteException;
import com.boardsite.adm.boardsiteadm.exception.ErrorCode;
import com.boardsite.adm.boardsiteadm.repository.chat.ChatRepository;
import com.boardsite.adm.boardsiteadm.repository.chat.ChatRoomPersonRepository;
import com.boardsite.adm.boardsiteadm.repository.user.TripUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final TripUserRepository tripUserRepository;
    private final ChatRoomPersonRepository chatRoomPersonRepository;
    private final ChatRoomPersonService chatRoomPersonService;
    public Page<ChatRoomDto> roomList(Pageable pageable) {
        return chatRepository.findByDeletedAndPublicRoom(false,true,pageable).map(ChatRoomDto::from);
    }

    @Transactional
    public String roomSave(ChatRoomDto dto , Long id) {
        var chatRoom =  chatRepository.saveAndFlush(dto.toEntity());
        chatRoom.personCountPlus(chatRoom.getRoomPersonIngCount());
        var tripUser = tripUserRepository.getReferenceById(id);
        var chatRoomPerson   = ChatRoomPerson.of(chatRoom,tripUser);
        chatRoomPersonRepository.save(chatRoomPerson);
        return chatRoom.getId().toString();
    }

    /*
     true / false 반환 이유 채팅방 인원을 다시 조회할지 말지 결정하기 때문에
     */
    @Transactional
    public boolean roomEnter(Long chatRoomId , Long userId) {
        var chatRoom = chatRepository.findById(chatRoomId).orElseThrow(() -> new BoardSiteException(ErrorCode.CHAT_ROOM_NOT_FOUND));
        var chatRoomPersonChk = chatRoomPersonService.roomUserChk(chatRoomId, userId);
        if (chatRoom.getRoomPersonIngCount() < chatRoom.getRoomCount()) {
            if (chatRoomPersonChk == 0) {
                chatRoom.personCountPlus(chatRoom.getRoomPersonIngCount());
                var tripUser = tripUserRepository.getReferenceById(userId);
                var chatRoomPerson = ChatRoomPerson.of(chatRoom, tripUser);
                chatRoomPersonRepository.save(chatRoomPerson);
                return true;
            }
                return false;
        } else {
            throw new BoardSiteException(ErrorCode.CHAT_ROOM_FULL_COUNT);
        }
    }

    @Transactional(readOnly = true)
    public String roomTitle(Long chatRoomId) {
        var chatRoom = chatRepository.findById(chatRoomId).orElseThrow(() -> new BoardSiteException(ErrorCode.CHAT_ROOM_NOT_FOUND));
        return chatRoom.getRoomName();
    }

}
