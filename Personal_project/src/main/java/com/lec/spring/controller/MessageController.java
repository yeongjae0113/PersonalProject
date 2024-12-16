package com.lec.spring.controller;

import com.lec.spring.domain.ChatRoom;
import com.lec.spring.domain.Message;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.service.ChatRoomService;
import com.lec.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private ChatRoomService chatRoomService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserRepository userRepository;

    // 메세지 전송
    @MessageMapping("/sendMessage/{chatRoomId}")
    @SendTo("/topic/public/{chatRoomId}")
    @Transactional
    public Message sendMessage(@DestinationVariable Long chatRoomId, @Payload Message message) {
        ChatRoom chatRoom = chatRoomService.findById(chatRoomId)
                .orElseThrow(() -> new RuntimeException("채팅방을 찾을 수 없음"));

        if (message.getSender() == null) {
            throw new RuntimeException("Sender 정보 없음");
        }
        message.setSendTime(LocalDateTime.now());
        message.setChatRoom(chatRoom);

        return messageService.sendMessage(message, message.getSender().getId());
    }

    // 메세지 리스트
    @GetMapping("/messageList/{chatRoomId}")
    public List<Message> showMessage(@PathVariable Long chatRoomId) {
        return messageService.showMessage(chatRoomId);
    }


}

