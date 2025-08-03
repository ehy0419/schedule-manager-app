///  패키지
package com.schedulemanagerapp.controller;

///  import 문
import com.schedulemanagerapp.dto.ScheduleResponse;
import com.schedulemanagerapp.dto.ScheduleRequest;
import com.schedulemanagerapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 패키지, import 문
//순서 이유 : 자바 클래스의 시작은 패키지 선언 후, 필요한 클래스를 가져오기 위한 import 문.
//역할 : 외부 라이브러리나 다른 패키지에 있는 클래스 사용을 가능하게 해준다.
//예: @RestController, @PostMapping, ScheduleService 등.

/// 클래스 선언부 및 의존성 주입
@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
//    private final ScheduleRepository scheduleRepository;    이것은 3계층 순서를 안 지킨 것
    //  controller -> service -> repository
//순서 이유 : 클래스 정의 -> 어노테이션으로 역할 부여 -> 필요한 서비스 선언
//역할
//@RestController: REST API 응답을 반환하는 컨트롤러임을 명시.
//@RequiredArgsConstructor: final 필드인 scheduleService를 자동 생성자 주입.
//ScheduleService: 비즈니스 로직을 담당하는 서비스 계층 호출.

    ///  메서드 작성 순서 CRUD 중 C. CREATE 일정 생성
    @PostMapping("/schedules")          ///  API 마다 DTO를 따로 만들어주는게 '정석'이다 (유지보수를 위해서)

    /// ResponseEntity 추가
    public ResponseEntity<ScheduleResponse> createSchedule(
            /// 원래 dto에 나누어서 만들어야한다.
            // ScheduleCreateRequest(또는 SaveRequest) , ScheduleUpdateRequest)
            @RequestBody ScheduleRequest scheduleRequest
    ) {
        return ResponseEntity.ok(scheduleService.save(scheduleRequest));
    }
//이유: 새로운 데이터를 저장하는 API를 가장 먼저 구현.
//@PostMapping: 클라이언트가 보낸 데이터를 저장 요청.
//@RequestBody: JSON으로 전달된 본문을 객체로 변환.

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
//이유: 저장된 데이터를 확인할 수 있도록 조회 기능 구현.
//@GetMapping: URL 호출만으로 데이터 조회.
//@PathVariable: 경로에 포함된 ID 값을 메서드 매개변수로 사용.

    ///  메서드 작성 순서 CRUD 중 U. UPDATE 일정 수정
//    @PutMapping("/schedules/{scheduleId}")
    @PatchMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponse> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleRequest scheduleRequest
    ) {
        return ResponseEntity.ok(scheduleService.updateSchedule(scheduleId, scheduleRequest));
    }
//이유: 데이터 조회 후, 수정할 수 있는 기능 추가.
//@PutMapping: 자원의 전체 수정을 의미하는 HTTP 메서드.
//ID를 기반으로 수정 대상 지정 → 새로운 값으로 덮어씀.

    ///  메서드 작성 순서 CRUD 중 D. DELETE 일정 삭제
    @DeleteMapping("/schedules/{scheduleId}")
    public void deleteSchedule(
            @PathVariable Long scheduleId
    ) {
        scheduleService.deleteSchedule(scheduleId);
    }
//이유: 불필요한 데이터를 제거할 수 있도록 마지막에 삭제 기능 구현.
//@DeleteMapping: 자원을 제거하는 HTTP 요청.
}

//✅ 전체 설계 흐름 요약
//의존성 주입으로 ScheduleService 연결
//REST API의 기본 원칙에 따라 HTTP 메서드로 CRUD 기능 분리:
//POST → 생성
//GET → 조회 (전체, 단건)
//PUT → 수정
//DELETE → 삭제
//URL 구조는 schedules로 일관성 있게 구성 (/schedules, /schedules/{id})

//✍️ 왜 이렇게 나누고 순서대로 쓰는가?
//가독성과 유지보수: 기능별로 나누면 다른 개발자도 쉽게 이해 가능
//RESTful 설계 원칙 준수: HTTP 메서드와 자원의 역할을 명확히 함
//Spring 관례: Controller → Service → Repository 계층 흐름을 따름
