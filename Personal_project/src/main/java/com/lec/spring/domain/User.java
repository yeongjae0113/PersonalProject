package com.lec.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // 유저 번호

    @Column(name = "userId", nullable = false)
    private String userId;      // 아이디

    @Column(nullable = false)
    private String password;    // 비밀번호

    @Column(nullable = false)
    private String username;    // 유저 이름

    @Column
    private String gender;      // 성별

    @Column
    private Long age;           // 나이

    @Column(name= "phonenumber")
    private String phoneNumber; // 휴대폰 번호

    @Column
    private String position;    // 직급

    @ManyToOne
    @JoinColumn(name = "department")
//    @JsonIgnore
    private Department department;  // 부서

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)   // 권한
    private Role role = Role.ROLE_USER;     // 기본값: 일반 유저

    @ManyToMany(mappedBy = "users")     // chatRoom 에서 정의한 users 필드 매핑
    @JsonIgnore    // JSON 직렬화에서 제외하여 무한 루프 방지
    @Builder.Default    // Builder 에서 설정하지 않으면 아래 new ArrayList<> 값이 기본 설정.
    private List<ChatRoom> chatRooms = new ArrayList<>();   // 사용자가 참여하는 채팅방 리스트

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Calendar> calendars = new ArrayList<>();

    @OneToMany(mappedBy = "sender")
    @ToString.Exclude
    @JsonIgnore
    private List<Message> messages;


}
