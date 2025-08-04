package com.schedulemanagerapp.dto;

import com.schedulemanagerapp.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ScheduleResponse {

    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime scheduleTime;

    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    ///  댓글 리스트 기능 추가


    public ScheduleResponse(Long id, String title, String description, LocalDateTime scheduleTime, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.scheduleTime = scheduleTime;

        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
