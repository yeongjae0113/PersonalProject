package com.lec.spring.service;

import com.lec.spring.domain.Department;
import com.lec.spring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    public DepartmentRepository departmentRepository;

    // 부서 생성
    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    // 부서 리스트 반환
    public List<Department> list() {
        return departmentRepository.findAll();
    }
}
