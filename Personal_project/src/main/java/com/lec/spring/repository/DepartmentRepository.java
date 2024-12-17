package com.lec.spring.repository;

import com.lec.spring.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // 부서 이름(PK)로 부서 검색
    Optional<Department> findByDepartment(String department);

    // 부서 삭제
    void deleteByDepartment(String department);
}
