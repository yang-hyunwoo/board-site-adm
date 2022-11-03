package com.boardsite.adm.boardsiteadm.repository.chat;

import com.boardsite.adm.boardsiteadm.domain.chat.ChatRoomMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ChatRoomMessageRepository extends JpaRepository<ChatRoomMessage, Long> {


    List<ChatRoomMessage> findByChatRoom_IdAndCreatedAtAfterOrderByCreatedAtAsc(Long id , LocalDateTime createdAt);
}
