package com.lec.spring.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "chatRoom")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatRoomId;    // 채팅방 id

    @Column(name = "createdAt", updatable = false)
    @Builder.Default
    private LocalDateTime createTime = LocalDateTime.now();     // 채팅방 생성일


    @ManyToMany
    @JoinTable(
            name = "chatRoom_users",    // 중간 테이블
            joinColumns = @JoinColumn(name = "chatRoomId"),     // chatRoom 외래키
            inverseJoinColumns = @JoinColumn(name = "userId")   // user 외래키
    )
    @Builder.Default
    private List<User> users = new ArrayList<>();   // 채팅방에 참여하고 있는 사용자 리스트

    // 포맷팅된 날짜와 시간을 반환하는 메소드
    public String getFormattedCreateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return createTime.format(formatter);
    }

}
