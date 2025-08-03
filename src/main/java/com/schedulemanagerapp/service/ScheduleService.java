package com.schedulemanagerapp.service;

import com.schedulemanagerapp.dto.ScheduleRequest;
import com.schedulemanagerapp.dto.ScheduleResponse;
import com.schedulemanagerapp.entity.Schedule;
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

    @Transactional
    public ScheduleResponse save(ScheduleRequest scheduleRequest) {
        Schedule schedule = new Schedule(scheduleRequest.getTitle());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getDescription(),
                savedSchedule.getScheduleTime()
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
                    schedule.getScheduleTime()
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
        return new ScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getDescription(),
                schedule.getScheduleTime()
        );
    }

    @Transactional
    public ScheduleResponse updateSchedule(Long scheduleId, ScheduleRequest scheduleRequest) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("일정 Id: " + scheduleId + " 가 존재하지 않습니다.")
        );
        schedule.updateSchedule(scheduleRequest.getTitle());
        return new ScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getDescription(),
                schedule.getScheduleTime()
        );
    }

    @Transactional
    public void deleteSchedule(Long scheduleId) {
        boolean exists = scheduleRepository.existsById(scheduleId);
        if (!exists) {
            throw new IllegalArgumentException("해당 일정 id는 존재하지 않습니다.");
        }
        scheduleRepository.deleteById(scheduleId);
    };
}
