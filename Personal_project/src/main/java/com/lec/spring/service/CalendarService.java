package com.lec.spring.service;

import com.lec.spring.domain.Calendar;
import com.lec.spring.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;

    // 모든 일정 가져오기
    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    // 일정 추가
    public Calendar save(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

}
