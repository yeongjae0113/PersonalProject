package com.lec.spring.service;

import com.lec.spring.domain.User;
import com.lec.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    // 회원가입
    public User save(User user) {
        return userRepository.save(user);
    }

    // 로그인
    public User login(String userId, String password) {
        User user = userRepository.findByUserId(userId).orElse(null);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // 유저 목록 반환
    public List<User> list() {
        return userRepository.findAll();
    }

    // 부서에 맞는 유저 반환
    public List<User> departmentList(String department) {
        return userRepository.findByDepartment(department);
    }

    // 유저 삭제
    public String delete(String userId) {
        User user = userRepository.findByUserId(userId).orElse(null);
        if (user != null) {
            userRepository.delete(user); // 유저 삭제
            return "success";
        }
        return "false";
    }

    // UserService.java
    public User updateUser(Long id, User updatedUser) {
        User users = userRepository.findById(id).orElse(null);
        if (users != null) {
            // 필요한 필드만 업데이트
            users.setUsername(updatedUser.getUsername());
            users.setPassword(updatedUser.getPassword());
            users.setPhoneNumber(updatedUser.getPhoneNumber());
            return userRepository.save(users);
        }
        return null; // 사용자 없음
    }

}
