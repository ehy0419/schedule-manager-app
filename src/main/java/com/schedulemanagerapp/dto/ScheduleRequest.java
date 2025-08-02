package com.schedulemanagerapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ScheduleRequest {

    private String scheduleName;
    private String scheduleDescription;
    private LocalDateTime scheduleTime;
}
