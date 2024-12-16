package com.lec.spring.service;

import com.lec.spring.domain.Department;
import com.lec.spring.domain.Role;
import com.lec.spring.domain.User;
import com.lec.spring.repository.DepartmentRepository;
import com.lec.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public DepartmentRepository departmentRepository;

    // 회원가입
    public User save(User user) {
        user.setRole(Role.ROLE_USER);   // 기본적으로 ROLE_USER 권한

        // 필수 필드인 userId, password, username 체크
        if (user.getUserId() == null || user.getPassword() == null || user.getUsername() == null) {
            throw new IllegalArgumentException("아이디, 비밀번호, 이름은 필수 항목입니다.");
        }

        // 유저가 속한 부서가 null 인지 확인
        if (user.getDepartment() != null) {
            // 유저가 속한 부서 가져오기
            Department department = departmentRepository.findByDepartment(user.getDepartment().getDepartment())
                    .orElse(null);

            user.setDepartment(department);  // department 를 직접 설정

            if (department != null) {
                user.setDepartment(department);
                // headcount 업데이트
                long userCount = userRepository.countByDepartment(department);
                department.setHeadcount(userCount + 1);
                departmentRepository.save(department);
            }
        }
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
    public List<User> departmentList(Department department) {
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

    // 유저 수정
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

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
