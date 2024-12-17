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
| - 💾 **부서별 유저 리스트 필터 구현** <br>- 🌐 **유저 CRUD 구현** <br>- 🛡️ **User 권한에 따른 사용자 분류** <br>- 🪪 **관리자 페이지 구현** <br>- 📊 **채팅방 CRUD 구현** <br>- 🎨 **일정 CRUD 구현** <br>- 🗃️ **부서 CRUD 구현** <br>- 🚀 **WebSocket과 STOMP 프로토콜을 활용한 실시간 채팅 구현** <br>- 🧪 **FullCalendar 라이브러리를 활용한 달력 구현** <br>- 🪪 **로그인한 유저 각자의 일정 관리 페이지에 접근 가능** |


## 📺 페이지 구성

| <div background-color="#f5f5f5"> 로그인 페이지 </div> |
| :-------------------------------------------: |
| <img width="100%" alt="로그인" src="https://github.com/user-attachments/assets/13ea7935-d9f5-4578-b009-37e33caa9d11" /> |
| <div align="left"> **사내 메신저 서비스를 이용하기 위해 로그인하는 페이지입니다.** </div> |

<br />

| <div style="background-color:#f5f5f5; border-radius:5px;"> 메인 페이지> </div> |
| :-------------------------------------------: |
| <img width="100%" alt="메인" src="https://github.com/user-attachments/assets/e60e88e8-815d-4e68-8e3e-568daaee4735" /> |
| <img width="49%" src="https://github.com/user-attachments/assets/4477d54f-e9a5-43f2-a7f9-a64ccc2a77ad" alt="메인 페이지 1" /> <img width="49%" src="https://github.com/user-attachments/assets/3db2ffa0-e9e3-418f-8ff8-2108ee824c42" alt="메인 페이지 2" /> |
| <div align="left">  **1. 부서를 클릭하면 해당 부서에 소속된 사원 목록을 볼 수 있습니다.** <br /> **2. 자신이 참여하고 있는 채팅방 목록을 볼 수 있습니다.** <br /> **3. 사원 목록을 한 번 클릭하여 채팅을 이용 할 수 있습니다.** <br /> **4. 사원을 더블 클릭하여 가입된 사원의 정보를 볼 수 있습니다.** </div> | 

<br />

| <div style="background-color:#f5f5f5; border-radius:5px;"> 일정 관리 페이지 </div> |
| :-------------------------------------------: |
| <img width="100%" alt="일정 관리 페이지" src="https://github.com/user-attachments/assets/b6ed08f5-8a85-471e-9305-1c3a2f548f55" /> |  
| <img width="49%" src="https://github.com/user-attachments/assets/1b7634d0-623e-472a-bca6-a62694b50102" alt="일정 추가 모달" /> <img width="49%" src="https://github.com/user-attachments/assets/a0692f50-6789-4a13-880d-d556b344bad1" alt="일정 수정 모달" /> |
| <div align="left"> **1. 로그인한 유저의 일정 관리를 할 수 있습니다.** <br /> **1. 일정을 새롭게 추가 할 수 있습니다.** <br /> **2. 추가된 일정을 수정 할 수 있습니다.** <br/> 권한에 따라 "master" 권한을 가진 유저는 공지 버튼이 있으며 모든 유저가 볼 수 있는 공지사항을 쓸 수 있습니다. </div> |

<br />

| <div style="background-color:#f5f5f5; border-radius:5px;"> 마이 페이지 및 수정 페이지 </div> |
| :-------------------------------------------: |
| <img width="49%" src="https://github.com/user-attachments/assets/10ad9cce-c311-41fd-980c-1f3c14f8aa5b" alt="마이 페이지 1"> <img width="49%" src="https://github.com/user-attachments/assets/5560776a-1534-4ff7-b6e5-1ee3b541bf86" alt="마이 페이지 2" /> |
| <div align="left"> **1. 자신의 회원 정보를 볼 수 있습니다.** <br/> **2. 성별, 나이, 부서, 직급을 제외한 사용자 이름, 비밀번호, 휴대전화번호를 수정할 수 있습니다.** </div> |

<br/>

| <div style="background-color:#f5f5f5; border-radius:5px;"> 관리자 페이지 </div> |
| :-------------------------------------------: |
| <img width="49%" src="https://github.com/user-attachments/assets/dc4c18ec-a887-4132-98bd-4b458181d03e" alt="부서 생성 모달" /> <img width="49%" src="https://github.com/user-attachments/assets/6097f6d2-58c5-42c0-9a1b-934ddc17b0a6" alt="사원 생성 모달" /> <img width="49%" src="https://github.com/user-attachments/assets/1b241a77-31a5-47db-8cba-bf8186c16e1f" alt="부서 생성 모달" /> <img width="49%" src="https://github.com/user-attachments/assets/ecce5edf-7551-4366-bae0-14bd1f338b83" alt="사원 생성 모달" /> |
| <div align="left"> **1. master 권한을 가진 회원이 접근 할 수 있는 관리자 페이지입니다.** <br /> **2. 권한을 포함한 사원 정보를 수정 할 수 있습니다.** <br /> **3. 부서를 추가 할 수 있습니다.** <br/> **4. 사원을 추가 할 수 있습니다.** </div> |

<br/>
