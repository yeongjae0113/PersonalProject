package com.lec.spring.repository;

import com.lec.spring.domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    // 각각 유저의 일정 반환
//    List<Calendar> findByUserId(Long userId);

    // 유저의 일정 가져오기
    @Query("SELECT c FROM Calendar c JOIN c.users u WHERE u.id = :userId")
    List<Calendar> findByUserId(@Param("userId") Long userId);

}
