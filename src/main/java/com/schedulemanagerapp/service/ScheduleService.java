package com.schedulemanagerapp.service;

import com.schedulemanagerapp.dto.ScheduleRequest;
import com.schedulemanagerapp.dto.ScheduleResponse;
import com.schedulemanagerapp.entity.Comment;
import com.schedulemanagerapp.entity.Schedule;
import com.schedulemanagerapp.repository.CommentRepository;
import com.schedulemanagerapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    /// 레벨 6: 댓글 조회를 위한 commentRepository 추가
    private final CommentRepository commentRepository;

    @Transactional
    public ScheduleResponse save(ScheduleRequest scheduleRequest) {

        ///  엔티티 스케줄에서 전체 필드를 받는 생성자 추가
        Schedule schedule = new Schedule(
                scheduleRequest.getTitle(),
                scheduleRequest.getDescription(),
                scheduleRequest.getScheduleTime()
        );

        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getDescription(),
                savedSchedule.getScheduleTime(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponse> findSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponse> scheduleResponseList = new ArrayList<>();

        for (Schedule schedule : schedules) {
            ScheduleResponse scheduleResponse = new ScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getDescription(),
                    schedule.getScheduleTime(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            scheduleResponseList.add(scheduleResponse);
        }
        /// 반환값 누락
        // 리스트 생성하고 데이터를 담았지만, return이 없었다.
        return scheduleResponseList;
    }

    @Transactional(readOnly = true)
    public ScheduleResponse findSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("일정 Id: " + scheduleId + " 가 존재하지 않습니다.")
        );
        // 레벨 6: 해당 일정에 등록된 댓글 목록 조회
        List<Comment> commentList = commentRepository.findByScheduleId(scheduleId);

        // 레벨 6: 댓글 포함된 ScheduleResponse 생성자 사용
        return new ScheduleResponse(schedule, commentList);

    }

    @Transactional
    public ScheduleResponse updateSchedule(Long scheduleId, ScheduleRequest scheduleRequest) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("일정 Id: " + scheduleId + " 가 존재하지 않습니다.")
        );

        ///  업데이트스케줄 메서드 호출 수정
        schedule.updateTitle(scheduleRequest.getTitle());
        schedule.updateDescription(scheduleRequest.getDescription());
        schedule.updateScheduleTime(scheduleRequest.getScheduleTime());
        return new ScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getDescription(),
                schedule.getScheduleTime(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public void deleteSchedule(Long scheduleId) {
        boolean exists = scheduleRepository.existsById(scheduleId);
        if (!exists) {
            throw new IllegalArgumentException("해당 일정 id는 존재하지 않습니다.");
        }
        scheduleRepository.deleteById(scheduleId);
    }
}
