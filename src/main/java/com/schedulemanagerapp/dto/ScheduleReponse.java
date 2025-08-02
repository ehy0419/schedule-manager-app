package com.schedulemanagerapp.dto;

import lombok.Getter;

@Getter
public class ScheduleReponse {

    private final Long scheduleId;
    private final String scheduleName;

    public ScheduleReponse(Long scheduleId, String scheduleName) {
        this.scheduleId = scheduleId;
        this.scheduleName = scheduleName;
    }
}
