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
    private Long id;

    @Column(name = "userId", nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Long age;

    @Column(name= "phonenumber", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String position;

    @ManyToMany(mappedBy = "users")     // chatRoom 에서 정의한 users 필드 매핑
    @JsonIgnore    // JSON 직렬화에서 제외하여 무한 루프 방지
    @Builder.Default    // Builder 에서 설정하지 않으면 아래 new ArrayList<> 값이 기본 설정.
    private List<ChatRoom> chatRooms = new ArrayList<>();   // 사용자가 참여하는 채팅방 리스트

    @OneToMany(mappedBy = "sender")
    @ToString.Exclude
    @JsonIgnore
    private List<Message> messages;

}
