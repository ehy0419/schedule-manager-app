package com.schedulemanagerapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ScheduleRequest {

    private String title;
    private String description;
    private LocalDateTime scheduleTime;
}

// 현재 ScheduleRequest 하나로 생성/수정 요청을 모두 처리하고 있다.
// 유지보수 측면에서 ScheduleCreateRequest, ScheduleUpdateRequest로 분리하는 것이 좋습니다.
