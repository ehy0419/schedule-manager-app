package com.schedulemanagerapp.dto;

import lombok.Getter;

@Getter
public class ScheduleResponse {

    private final Long scheduleId;
    private final String scheduleName;

    public ScheduleResponse(Long scheduleId, String scheduleName) {
        this.scheduleId = scheduleId;
        this.scheduleName = scheduleName;
    }
}
