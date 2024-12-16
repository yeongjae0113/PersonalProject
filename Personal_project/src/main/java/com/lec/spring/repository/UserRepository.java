package com.lec.spring.repository;

import com.lec.spring.domain.Department;
import com.lec.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 유저 id가 DB에 있는지 확인 후 로그인
    Optional<User> findByUserId(String userId);

    // 부서에 맞는 유저목록 가져오기
    List<User> findByDepartment(Department department);

    // 특정 부서에 속한 유저 수 계산 (headCount)
    Long countByDepartment(Department department);
}
