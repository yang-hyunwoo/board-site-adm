package com.boardsite.adm.boardsiteadm.repository.chat;

import com.boardsite.adm.boardsiteadm.domain.chat.ChatRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatRoom, Long> {

    Page<ChatRoom> findByDeletedAndPublicRoom(boolean deleted , boolean publicRoom , Pageable pageable);

}
