package com.lec.spring.Controller;

import com.lec.spring.domain.ChatRoom;
import com.lec.spring.domain.User;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.service.ChatRoomService;
import com.lec.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam String userId, @RequestParam String password) {
        User user = userService.login(userId, password);
        if (user != null) {
            return ResponseEntity.ok(user); // 로그인 성공
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // 로그인 실패
        }
    }

    @PostMapping("/join")
    public User join(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> list() {
        List<User> users = userService.list();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/departmentList")
    public ResponseEntity<List<User>> departmentList(String department) {
        List<User> users = userService.departmentList(department);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam String userId) {
        String result = userService.delete(userId);
        return ResponseEntity.ok(result);
    }

//    @GetMapping("/chatRoom")
//    public List<ChatRoom> chatRoomList(@RequestParam Long userId) {
//        return chatRoomService.getChatRooms(userId);
//    }
}