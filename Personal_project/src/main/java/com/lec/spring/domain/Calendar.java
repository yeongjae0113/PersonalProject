package com.lec.spring.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;              // 유저와의 관계

    @Column(nullable = false)
    private String title;           // 일정 제목

    @Column
    private String description;     // 일정 내용

    @Column(nullable = false)
    private LocalDate date;         // 일정 날짜
}