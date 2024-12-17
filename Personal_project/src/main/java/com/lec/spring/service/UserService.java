package com.lec.spring.service;

import com.lec.spring.domain.Department;
import com.lec.spring.domain.Role;
import com.lec.spring.domain.User;
import com.lec.spring.repository.DepartmentRepository;
import com.lec.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    // 유저가 수정
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

    // 관리자가 수정
    @Transactional
    public User updateMaster(Long id, User updatedMaster) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            // 기존 부서 가져오기
            Department currentDepartment = user.getDepartment();
            Department newDepartment = updatedMaster.getDepartment(); // 새로운 부서 정보

            // 부서 이름을 기준으로 새로운 부서를 찾아서 설정
            if (newDepartment != null && !newDepartment.getDepartment().equals(currentDepartment.getDepartment())) {
                // 새로운 부서가 기존 부서와 다르면 부서 변경 처리
                Department departmentFromDb = departmentRepository.findByDepartment(newDepartment.getDepartment())
                        .orElse(null);

                if (departmentFromDb != null) {
                    newDepartment = departmentFromDb;  // 실제 부서 객체로 설정
                }
            }

            // 부서 변경이 있으면 headcount 업데이트
            if (currentDepartment != null && !currentDepartment.equals(newDepartment)) {
                // 1. 기존 부서의 headcount 감소
                long currentHeadcount = currentDepartment.getHeadcount();
                currentDepartment.setHeadcount(currentHeadcount - 1);
                departmentRepository.save(currentDepartment); // 기존 부서 정보 저장

                // 2. 새로운 부서의 headcount 증가
                long newHeadcount = newDepartment.getHeadcount();
                newDepartment.setHeadcount(newHeadcount + 1);
                departmentRepository.save(newDepartment); // 새로운 부서 정보 저장

                // 부서 변경 처리
                user.setDepartment(newDepartment); // 변경된 부서 설정
            }

            // 필드 업데이트
            user.setUserId(updatedMaster.getUserId());
            user.setUsername(updatedMaster.getUsername());
            user.setPassword(updatedMaster.getPassword());
            user.setPhoneNumber(updatedMaster.getPhoneNumber());
            user.setAge(updatedMaster.getAge());
            user.setGender(updatedMaster.getGender());
            user.setPosition(updatedMaster.getPosition());
            user.setRole(updatedMaster.getRole());

            System.out.println("직급 잘 가져왔니?: " + updatedMaster.getPosition());
            System.out.println("user정보: " + updatedMaster);

            return userRepository.save(user); // 사용자 정보 저장
        }
        return null; // 사용자가 존재하지 않는 경우
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
