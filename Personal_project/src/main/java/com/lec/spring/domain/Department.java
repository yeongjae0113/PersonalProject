package com.lec.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "department")
public class Department {

    @Id
    private String department;      // 부서 이름 (Primary Key)

    @Column(nullable = false)
    private String departmentNumber;    // 부서 전화번호

    @Column(nullable = false)
    private String departmentLocation;  // 부서 위치

    @Column(nullable = false)
    private Long headcount;     // 인원수

    @OneToMany(mappedBy = "department") // User와의 관계 설정
    @JsonIgnore
    private List<User> users; // 해당 부서에 속한 유저 목록

    public Department(String department) {
        this.department = department;
    }
}
