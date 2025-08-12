package com.schedulemanagerapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ScheduleRequest
 * -------------------
 * 일정 생성/수정 요청에 사용하는 DTO.
 * - 컨트롤러로 들어오는 외부 입력을 표현한다.
 * - 유효성 검사는 여기에서 수동(validate) 또는 Bean Validation으로 처리 가능.
 */

@Getter
@NoArgsConstructor
public class ScheduleRequest {

    private String title;
    private String description;
    private LocalDateTime scheduleTime;

    /**
     * 수동 유효성 검사(간단 버전)
     * - 실제 운영에서는 Bean Validation(@NotBlank, @Size, @Future 등) 사용 권장
     */

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
