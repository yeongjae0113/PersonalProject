package com.lec.spring.controller;

import com.lec.spring.domain.Department;
import com.lec.spring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public Department create(@RequestBody Department department) {
        return departmentService.create(department);
    }

    @DeleteMapping("/delete/{department}")
    public void delete(@PathVariable String department) {
        departmentService.delete(department);
    }

    @GetMapping("/list")
    public List<Department> list() {
        return departmentService.list();
    }
}