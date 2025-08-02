package com.schedulemanagerapp.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequest {

    private String scheduleName;
    private String scheduleDescription;
    private LocalDateTime scheduleStartTime;
    private LocalDateTime scheduleEndTime;
}
