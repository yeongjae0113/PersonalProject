package com.lec.spring.controller;

import com.lec.spring.domain.ChatRoom;
import com.lec.spring.repository.ChatRoomRepository;
import com.lec.spring.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatRoomController {

    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private ChatRoomService chatRoomService;


    @PostMapping("/create")
    public ChatRoom create(@RequestBody List<Long> userId) {
        return chatRoomService.create(userId);
    }

    @GetMapping("/chatRoom")
    public ResponseEntity<List<ChatRoom>> chatRoomList(@RequestParam Long userId) {
        List<ChatRoom> chatRooms = chatRoomRepository.findByUsers_Id(userId);
        return ResponseEntity.ok(chatRooms);
    }
}
