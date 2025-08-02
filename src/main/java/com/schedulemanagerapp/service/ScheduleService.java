package com.schedulemanagerapp.service;

import com.schedulemanagerapp.dto.ScheduleResponse;
import com.schedulemanagerapp.dto.ScheduleRequest;
import com.schedulemanagerapp.entity.Schedule;
import com.schedulemanagerapp.repository.ScheduleRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Getter
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponse save(ScheduleRequest scheduleRequest) {
        Schedule savedSchedule = scheduleRepository.save(new Schedule(scheduleRequest.getScheduleName()));
        return new ScheduleResponse(savedSchedule.getScheduleId(), savedSchedule.getScheduleName());
    }
}
