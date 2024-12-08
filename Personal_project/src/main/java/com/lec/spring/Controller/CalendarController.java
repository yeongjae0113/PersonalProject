package com.lec.spring.Controller;

import com.lec.spring.domain.Calendar;
import com.lec.spring.domain.User;
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
    private CalendarService calendarService;
    @Autowired
    private UserService userService;

    // 모든 일정 가져오기
    @GetMapping
    public ResponseEntity<List<Calendar>> getAllCalendar() {
        List<Calendar> calendar = calendarService.findAll();
        return ResponseEntity.ok(calendar);
    }

    // 일정 추가
    @PostMapping("/save")
    public ResponseEntity<Calendar> create(@RequestBody Calendar calendar) {
        User user = userService.findById(calendar.getUser().getId());
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        calendar.setUser(user);
        Calendar save = calendarService.save(calendar);
        return ResponseEntity.ok(save);
    }

    // 일정 수정
    @PostMapping("/update/{id}")
    public ResponseEntity<Calendar> update(@PathVariable Long id, @RequestBody Calendar calendar) {
        Calendar update = calendarService.update(id, calendar);
        if (update != null) {
            return ResponseEntity.ok(update);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
