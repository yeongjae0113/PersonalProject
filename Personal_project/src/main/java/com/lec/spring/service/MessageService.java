package com.lec.spring.service;

import com.lec.spring.domain.ChatRoom;
import com.lec.spring.domain.Message;
import com.lec.spring.domain.User;
import com.lec.spring.repository.MessageRepository;
import com.lec.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRoomService chatRoomService;

    // 메세지 전송
    public Message sendMessage(Message message, Long senderId) {
        if (senderId != null) {
            User sender = userRepository.findById(senderId)
                    .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없음"));
            message.setSender(sender);
        } else {
            throw new RuntimeException("유저 오류오류");
        }
        message.setSendTime(LocalDateTime.now());

        Message saveMessage = messageRepository.save(message);

        updateChatRoomUsersAfterMessage(message.getChatRoom().getChatRoomId());

        return saveMessage;
    }

    // 채팅방 사원 리스트 갱신
    private void updateChatRoomUsersAfterMessage(Long chatRoomId) {
        // 채팅방을 가져오고, 해당 채팅방에 참여한 사원 리스트를 다시 필터링
        ChatRoom chatRoom = chatRoomService.findById(chatRoomId)
                .orElseThrow(() -> new RuntimeException("채팅방을 찾을 수 없음"));

        // 여기에 부서별로 필터링을 추가할 수 있습니다. 예: "개발팀"만 필터링
        List<User> usersInChatRoom = chatRoom.getUsers().stream()
                .filter(user -> user.getDepartment().equals("개발팀"))
                .filter(user -> user.getDepartment().equals("인사팀"))
                .filter(user -> user.getDepartment().equals("총무팀"))
                .collect(Collectors.toList());

        // 필터링된 사원 리스트를 프론트엔드에 전달할 수 있도록 반환
        // 프론트엔드에서는 이 정보를 사용하여 UI를 업데이트하도록 합니다.
    }

    // 메세지 리스트
    public List<Message> showMessage(Long chatRoomId) {
        return messageRepository.findByChatRoom_ChatRoomId(chatRoomId); // 수정된 메소드 호출
    }
}
