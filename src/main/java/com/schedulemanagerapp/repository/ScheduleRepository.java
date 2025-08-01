package com.schedulemanagerapp.repository;

import com.schedulemanagerapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
