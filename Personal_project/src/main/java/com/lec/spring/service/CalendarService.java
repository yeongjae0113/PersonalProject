package com.lec.spring.service;

import com.lec.spring.domain.Calendar;
import com.lec.spring.domain.Role;
import com.lec.spring.domain.User;
import com.lec.spring.repository.CalendarRepository;
import com.lec.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;
    @Autowired
    private UserRepository userRepository;

    public Calendar addCalendar(Calendar calendar, Long id) {
        // 일정을 추가하는 유저를 찾습니다.
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        calendar.setUser(user);

        // 공지 여부에 따라 처리
        if (calendar.isNotice()) {
            // 공지 일정일 경우, 모든 유저에게 일정을 공유
            List<User> allUsers = userRepository.findAll();  // 모든 유저를 찾음
            calendar.setUsers(allUsers);  // 모든 유저에게 일정을 공유
        } else {
            // 일반 일정일 경우, 개인 일정으로 저장
            calendar.setUsers(List.of(user));  // 본인만 일정 보기
        }

        // 일정을 저장하고 반환
        return calendarRepository.save(calendar);
    }

    // 유저 ID로 해당 유저의 모든 일정을 가져오는 서비스
    public List<Calendar> getAllCalendar(Long userId) {
        List<Calendar> calendars = calendarRepository.findByUserId(userId);

        // 공지일정은 모든 유저에게 보여야 하므로 users 에 포함된 유저를 확인
        for (Calendar calendar : calendars) {
            if (calendar.isNotice()) {
                // 공지일정은 모든 유저가 볼 수 있도록 설정
                calendar.setUsers(userRepository.findAll());
            } else {
                calendar.setUsers(List.of(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"))));
            }
        }
        return calendars;    }

    // 일정 수정
    public Calendar update(Long calendarId, Calendar updateCalendar) {
        Calendar calendar = calendarRepository.findById(calendarId).orElse(null);
        if (calendar != null) {
            calendar.setTitle(updateCalendar.getTitle());
            calendar.setDescription(updateCalendar.getDescription());
            calendar.setStartDate(updateCalendar.getStartDate());
            calendar.setEndDate(updateCalendar.getEndDate());
            calendar.setNotice(updateCalendar.isNotice());

            // 공지일 경우 모든 유저들에게 반환
            if (calendar.isNotice()) {
                List<User> allUsers = userRepository.findAll();
                calendar.setUsers(allUsers);
            } else {
                // 개인 일정일 경우, 자신에게만 반환
                calendar.setUsers(new ArrayList<>());
                calendar.getUsers().add(calendar.getUser());
            }
            return calendarRepository.save(calendar);
        }
        return null;
    }

}
