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

    public String validate() {

        // 조건 1 : 일정 제목은 최대 30자 이내, 필수값
        if (title == null || title.isEmpty()) {
            return "일정 제목은 필수입니다.";
        }
        if (title.length() > 30) {
            return "일정 제목은 최대 30글자까지 입력 가능합니다.";
        }

        // 조건 2 : 일정 내용은 최대 200자 이내, 필수값
        if (description == null || description.isEmpty()) {
            return "일정 내용은 필수입니다.";
        }
        if (description.length() > 200) {
            return "일정 내용은 최대 200글자까지 입력 가능합니다.";
        }

        // 조건 3 : 일정 시간은 필수 - '현재 시간 이후로만 일정을 등록할 수 있어요.'
        if (scheduleTime == null || scheduleTime.isBefore(LocalDateTime.now())) {
            return "현재 시간 이후로만 일정을 등록할 수 있어요.";
        }
        return null;
    }
}

// 현재 ScheduleRequest 하나로 생성/수정 요청을 모두 처리하고 있다.
// 유지보수 측면에서 ScheduleCreateRequest, ScheduleUpdateRequest로 분리하는 것이 좋습니다.
