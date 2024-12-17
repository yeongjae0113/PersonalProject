package com.lec.spring.controller;
import com.lec.spring.domain.Department;
import com.lec.spring.domain.User;
import com.lec.spring.domain.UserDTO;
import com.lec.spring.repository.DepartmentRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.service.ChatRoomService;
import com.lec.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRoomService chatRoomService;
    @Autowired
    private DepartmentRepository departmentRepository;


    @GetMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestParam String userId, @RequestParam String password) {
        User user = userService.login(userId, password);
        if (user != null) {
            UserDTO userDTO = new UserDTO(user); // User 엔티티를 UserDTO 로 변환
            return ResponseEntity.ok(userDTO); // UserDTO 반환
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // 로그인 실패
        }
    }

    @PostMapping("/join")
    public ResponseEntity<UserDTO> join(@RequestBody UserDTO userDTO) {
        // department 가 null 일 경우 처리
        if (userDTO.getDepartment() == null || userDTO.getDepartment().getDepartment() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null); // 적절한 에러 메시지 추가 가능
        }

        // department 이름으로 부서 찾기
        Department department = departmentRepository.findByDepartment(userDTO.getDepartment().getDepartment())
                .orElse(null);

        if (department == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // 부서가 없을 경우 처리
        }

        // UserDTO 를 User 엔티티로 변환
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setGender(userDTO.getGender());
        user.setAge(userDTO.getAge());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setPosition(userDTO.getPosition());
        user.setDepartment(department);

        User saveUser = userService.save(user);  // 저장된 User 엔티티 반환
        UserDTO saveUserDTO = new UserDTO(saveUser);  // 저장된 User 엔티티를 UserDTO로 변환

        return ResponseEntity.status(HttpStatus.CREATED).body(saveUserDTO);
    }



    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> list() {
        List<User> users = userService.list();
        List<UserDTO> userDTOs = users.stream()
                .map(UserDTO::new)  // User 엔티티를 UserDTO로 변환
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("/departmentList")
    public ResponseEntity<List<UserDTO>> departmentList(@RequestParam String department) {
        Department dept = new Department();
        dept.setDepartment(department);  // 부서 이름을 Dept 객체로 변환
        List<User> users = userService.departmentList(dept);  // 서비스로 Dept 객체 전달
        List<UserDTO> userDTOs = users.stream()
                .map(UserDTO::new)  // User 엔티티를 UserDTO로 변환
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam String userId) {
        String result = userService.delete(userId);
        return ResponseEntity.ok(result);
    }

    // 유저가 수정
    @PostMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = userService.updateUser(id, user);
        if (updateUser != null) {
            return ResponseEntity.ok(updateUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // 관리자가 수정
    @PutMapping("/updateMaster/{id}")
    public ResponseEntity<User> updateMaster(@PathVariable Long id, @RequestBody User user) {
        System.out.println("수정하려는 유저 ID: " + id);
        System.out.println("전달된 유저 정보: " + user);
        User updateMaster = userService.updateMaster(id, user);
        if (updateMaster != null) {
            return ResponseEntity.ok(updateMaster);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}