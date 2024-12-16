package com.lec.spring.repository;

import com.lec.spring.domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    // 각각 유저의 일정 반환
    List<Calendar> findByUserId(Long userId);

}
