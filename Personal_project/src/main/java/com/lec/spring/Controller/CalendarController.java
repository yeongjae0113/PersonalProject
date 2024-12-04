package com.lec.spring.Controller;

import com.lec.spring.domain.Calendar;
import com.lec.spring.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    // 모든 일정 가져오기
    @GetMapping
    public ResponseEntity<List<Calendar>> getAllCalendar() {
        List<Calendar> calendar = calendarService.findAll();
        return ResponseEntity.ok(calendar);
    }

    // 일정 추가
    @PostMapping("/save")
    public ResponseEntity<Calendar> create(@RequestBody Calendar calendar) {
        Calendar save = calendarService.save(calendar);
        return ResponseEntity.ok(save);
    }
}
