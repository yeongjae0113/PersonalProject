package com.lec.spring.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String userId;
    private String password;
    private String username;
    private String gender;
    private Long age;
    private String phoneNumber;
    private String position;
    private Department department;  // 부서 이름만 반환
    private String role;

    // User 엔티티를 DTO로 변환하는 생성자
    public UserDTO(User user) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.gender = user.getGender();
        this.age = user.getAge();
        this.phoneNumber = user.getPhoneNumber();
        this.position = user.getPosition();
        this.department = user.getDepartment();
        this.role = user.getRole().name();
    }
}
