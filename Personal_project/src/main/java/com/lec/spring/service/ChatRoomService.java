package com.lec.spring.service;

import com.lec.spring.domain.ChatRoom;
import com.lec.spring.domain.User;
import com.lec.spring.repository.ChatRoomRepository;
import com.lec.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private UserRepository userRepository;

    public ChatRoom create(List<Long> userIds) {
        ChatRoom chatRoom = new ChatRoom();

        // 유저 리스트를 채팅방에 추가
        for (Long userId : userIds) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없음"));
            chatRoom.getUsers().add(user);  // 채팅방에 유저 추가
        }

        // 채팅방을 저장
        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }

    // ChatRoom ID로 조회
    public Optional<ChatRoom> findById(Long chatRoomId) {
        return chatRoomRepository.findById(chatRoomId);
    }

    public List<ChatRoom> getChatRooms(Long userId) {
        return chatRoomRepository.findByUsers_Id(userId);
    }

}
