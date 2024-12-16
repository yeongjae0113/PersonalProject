package com.lec.spring.repository;

import com.lec.spring.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;
import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    // 유저가 참여 중인 채팅방 목록 반환
    List<ChatRoom> findByUsers_Id(Long userId);
}
