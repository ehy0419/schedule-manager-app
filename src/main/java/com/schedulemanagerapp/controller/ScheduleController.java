package com.schedulemanagerapp.controller;

import com.schedulemanagerapp.dto.ScheduleResponse;
import com.schedulemanagerapp.dto.ScheduleRequest;
import com.schedulemanagerapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    ///  메서드 작성 순서 CRUD 중 C. CREATE 일정 생성
    @PostMapping("/schedules")          ///  API 마다 DTO를 따로 만들어주는게 '정석'이다 (유지보수를 위해서)

    /// ResponseEntity 추가
    public ResponseEntity<ScheduleResponse> createSchedule(
            /// 원래 dto에 나누어서 만들어야한다.
            // ScheduleCreateRequest(또는 SaveRequest) , ScheduleUpdateRequest)
            @RequestBody ScheduleRequest scheduleRequest
            // (선택) scheduleRequest.validate() 를 호출하여 수동 검증할 수도 있음
//            @Valid @RequestBody ScheduleCreateRequest request // @Valid로 자동 검증
            // Spring이 자동으로 400 Bad Request + 에러 메시지를 내려줍니다.
    ) {
        return ResponseEntity.ok(scheduleService.save(scheduleRequest));
    }

    /// 메서드 작성 순서 CRUD 중 R. READ 전체 조회
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponse>> getSchedules() {
        return ResponseEntity.ok(scheduleService.findSchedules());
    }
    // 수정 전
//    return scheduleService.findSchedules();
    // 수정 후
//    return ResponseEntity.ok(scheduleService.findSchedules());

    /// 메서드 작성 순서 CRUD 중 R. READ 단건 조회
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponse> getSchedule(
            @PathVariable Long scheduleId
    ) {
        return ResponseEntity.ok(scheduleService.findSchedule(scheduleId));
    }

    ///  메서드 작성 순서 CRUD 중 U. UPDATE 일정 수정
    @PatchMapping("/schedules/{scheduleId}")            //    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponse> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleRequest scheduleRequest
    ) {
        return ResponseEntity.ok(scheduleService.updateSchedule(scheduleId, scheduleRequest));
    }

    ///  메서드 작성 순서 CRUD 중 D. DELETE 일정 삭제
    @DeleteMapping("/schedules/{scheduleId}")
    public void deleteSchedule(
            @PathVariable Long scheduleId
    ) {
        scheduleService.deleteSchedule(scheduleId);
    }
}