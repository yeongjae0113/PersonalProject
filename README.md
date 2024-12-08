# 🏬 Personal Project - 사내 메신저 서비스
> **개발 기간 : 2024.11 ~ 진행중**

<div align="center">
<!-- <img width="100" src="스크린샷 2024-12-05 054529.png" alt="스크린샷"> -->
<img width="500" src="스크린샷 2024-12-05 062304.png" alt="스크린샷">
</div>
<br/>

## 🚀 프로젝트 소개
Personal Project는 사내 메신저로 회사의 각 부서에 소속된 직원들이 실시간으로 소통할 수 있는 플랫폼입니다. <br/>
이 서비스는 사용자 친화적인 인터페이스를 제공하며, 로그인 및 회원가입 기능을 통해 안전하게 접근할 수 있습니다. <br/>
일정 관리 기능을 통해 사용자는 개인 일정을 쉽게 관리 할 수 있으며, 캘린더를 통해 중요한 일정과 회의를 시각적으로 확인 할 수 있습니다. <br/>
또한, 부서별 필터링 기능을 통해 필요한 정보를 쉽게 찾을 수 있으며, 개인 및 그룹 채팅 기능을 통해 효율적인 커뮤니케이션을 지원합니다. <br/>

## 🛠️ 기술 스택

### Environment  
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=fff) 
![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=fff&style=for-the-badge) 
![Spring](https://img.shields.io/badge/Spring-6DB33F?logo=spring&logoColor=fff&style=for-the-badge) 
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff&style=for-the-badge) 
![Node.js](https://img.shields.io/badge/Node.js-5FA04E?logo=nodedotjs&logoColor=fff&style=for-the-badge)

### Config  
![Gradle](https://img.shields.io/badge/Gradle-02303A?logo=gradle&logoColor=fff&style=for-the-badge)

### Development  
![React](https://img.shields.io/badge/React-61DAFB?logo=react&logoColor=000&style=for-the-badge) 
![HTML5](https://img.shields.io/badge/HTML5-E34F26?logo=html5&logoColor=fff&style=for-the-badge) 
![CSS3](https://img.shields.io/badge/CSS3-1572B6?logo=css3&logoColor=fff&style=for-the-badge) 
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?logo=javascript&logoColor=000&style=for-the-badge) 
![Axios](https://img.shields.io/badge/Axios-5A29E4?logo=axios&logoColor=fff&style=for-the-badge)

## 🙋‍♂️ 주요 기능
| 🙋‍♂️ 기능 설명 |
|--------------|
| - 💾 **부서별 유저 리스트 필터 구현** <br> - 🌐 **유저 CRUD 구현** <br> - 📊 **채팅방 CRUD 구현** <br> - 🎨 **일정 CRUD 구현** <br> - 🚀 **WebSocket과 STOMP 프로토콜을 활용한 실시간 채팅 구현** <br> - 🧪 **FullCalendar 라이브러리를 활용한 달력 구현** <br> - 🪪 **로그인한 유저 각자의 일정 관리 페이지에 접근 가능** <br> -> 렌더링 된 일정을 클릭하면 "일정 수정" Modal 창 <br> -> 빈 셀을 클릭하면 "일정 추가" Modal 창|



## 📺 페이지 구성

### 1. 로그인 페이지
![로그인 페이지](https://github.com/user-attachments/assets/9f14e5b2-f37e-4379-a1dc-fc1939ddecae)  
<div style="background-color: #f0f0f0; padding: 10px; border-radius: 5px;">
    
**사내 메신저 서비스를 이용하기 위해 로그인하는 페이지입니다.** 
</div>
<br/>

### 2. 회원가입 페이지
![회원가입 페이지](https://github.com/user-attachments/assets/f77db02a-5441-4d96-823e-f38ec4478985)  
<div style="background-color: #f0f0f0; padding: 10px; border-radius: 5px;">
    
**사내 메신저를 이용하기 전 개인정보를 기입하여 회원가입하는 페이지입니다.** 
</div>
<br/>

### 3. 메인 페이지
<div>
    <img src="https://github.com/user-attachments/assets/1e7775a7-735f-48e5-9b2f-205c0c5fb6dc" alt="메인 페이지 1" style="display:inline-block; width:48%; margin-right: 2%;">
    <img src="https://github.com/user-attachments/assets/08664e19-a574-40e7-b743-3b172bb04eff" alt="메인 페이지 2" style="display:inline-block; width:48%;">
</div>
<div style="background-color: #f0f0f0; padding: 10px; border-radius: 5px;">
    
**1. 부서 필터를 클릭하여 부서별 사원 리스트를 볼 수 있습니다.** <br/>
**2. 자신이 참여하고 있는 채팅방 목록을 볼 수 있습니다.** 

</div>
<br/>

### 4. 일정 관리 페이지
![스크린샷 2024-12-09 054259](https://github.com/user-attachments/assets/2e82af1d-8531-4d79-b69c-bfca0a2dfaee)
<div style="background-color: #f0f0f0; padding: 10px; border-radius: 5px;">
    
**로그인 한 유저의 일정 관리를 할 수 있는 페이지입니다.** 
<div>
    <img src="https://github.com/user-attachments/assets/23e0b0be-b67c-4e4f-9131-c5d68327b7d9" alt="메인 페이지 1" style="display:inline-block; width:48%; margin-right: 2%;">
    <img src="https://github.com/user-attachments/assets/b8f62db3-dd5c-4ac8-b8be-a798a99d9b79" alt="메인 페이지 2" style="display:inline-block; width:48%;">

</div>
<br/>

<div style="background-color: #f0f0f0; padding: 10px; border-radius: 5px;">
    
**1. 일정을 새롭게 추가 할 수 있습니다.** <br/>
**2. 추가된 일정을 다시 할 수 있습니다.**
</div>
<br/>

### 5. 마이 페이지 및 수정 페이지
<div>
    <img src="https://github.com/user-attachments/assets/9b82664b-b451-4a27-a631-72ea4c6dc5b8" alt="마이 페이지 1" style="display:inline-block; width:48%; margin-right: 2%;">
    <img src="https://github.com/user-attachments/assets/9f3e92ce-542c-4515-b010-db9e7f5e01d2" alt="마이 페이지 2" style="display:inline-block; width:48%;">
</div>
<div style="background-color: #f0f0f0; padding: 10px; border-radius: 5px;">
    
**1. 자신의 회원 정보를 볼 수 있습니다.**  <br/>
**2. 성별, 나이, 부서, 직급을 제외한 사용자 이름, 비밀번호, 휴대전화번호를 수정할 수 있습니다.** 
</div>
