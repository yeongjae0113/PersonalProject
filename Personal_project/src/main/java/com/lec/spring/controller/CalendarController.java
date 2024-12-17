package com.lec.spring.controller;

import com.lec.spring.domain.Calendar;
import com.lec.spring.domain.User;
import com.lec.spring.repository.CalendarRepository;
import com.lec.spring.service.CalendarService;
import com.lec.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private CalendarRepository calendarRepository;
    @Autowired
    private CalendarService calendarService;
    @Autowired
    private UserService userService;

    // 모든 일정 (master 가 공지한 일정)
    @PostMapping("/add")
    public ResponseEntity<Calendar> addCalendar(@RequestBody Calendar calendar,
                                                @RequestParam Long id) {
        Calendar savedCalendar = calendarService.addCalendar(calendar, id);
        return ResponseEntity.ok(savedCalendar);
    }

    // 각 유저의 일정 가져오기
    @GetMapping
    public ResponseEntity<List<Calendar>> getAllCalendar(@RequestParam Long userId) {
        List<Calendar> calendars = calendarService.getAllCalendar(userId);
        return ResponseEntity.ok(calendars);
    }

    // 일정 수정
    @PostMapping("/update/{calendarId}")
    public ResponseEntity<Calendar> update(@PathVariable Long calendarId, @RequestBody Calendar calendar) {
        Calendar update = calendarService.update(calendarId, calendar);
        if (update != null) {
            return ResponseEntity.ok(update);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
