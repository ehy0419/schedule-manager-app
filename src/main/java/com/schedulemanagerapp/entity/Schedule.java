package com.schedulemanagerapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    private String scheduleName;
    private String scheduleDescription;
    private LocalDateTime scheduleStartTime;
    private LocalDateTime scheduleEndTime;

    public Schedule(String scheduleName, String scheduleDescription, LocalDateTime scheduleStartTime, LocalDateTime scheduleEndTime) {
        this.scheduleName = scheduleName;
        this.scheduleDescription = scheduleDescription;
        this.scheduleStartTime = scheduleStartTime;
        this.scheduleEndTime = scheduleEndTime;
    }

    public void updateSchedule(Schedule schedule) {
        this.scheduleName = schedule.getScheduleName();
        this.scheduleDescription = schedule.getScheduleDescription();
    }
}
