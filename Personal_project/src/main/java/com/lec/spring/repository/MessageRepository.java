package com.lec.spring.repository;

import com.lec.spring.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // ChatRoom 객체를 기준으로 메시지를 찾기
    List<Message> findByChatRoom_ChatRoomId(Long chatRoomId);

}
