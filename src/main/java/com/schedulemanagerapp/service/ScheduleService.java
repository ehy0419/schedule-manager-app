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
    public ScheduleResponse save(ScheduleRequest req) {
        Schedule saved = scheduleRepository.save(
                new Schedule(req.getScheduleName(), req.getScheduleDescription(), req.getScheduleTime())
        );
        return new ScheduleResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getDescription(),
                saved.getScheduleTime()
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponse> findSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponse> responses = new ArrayList<>();
        for (Schedule s : schedules) {
            responses.add(new ScheduleResponse(
                    s.getId(),
                    s.getTitle(),
                    s.getDescription(),
                    s.getScheduleTime()
            ));
        }
        return responses;
    }

    @Transactional(readOnly = true)
    public ScheduleResponse findSchedule(Long id) {
        Schedule s = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정 id: " + id + " 존재하지 않습니다."));
        return new ScheduleResponse(
                s.getId(),
                s.getTitle(),
                s.getDescription(),
                s.getScheduleTime()
        );
    }

    @Transactional
    public ScheduleResponse update(Long id, ScheduleRequest req) {
        Schedule s = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정 id: " + id + " 존재하지 않습니다."));
        s.update(req.getScheduleName(), req.getScheduleDescription(), req.getScheduleTime());
        return new ScheduleResponse(
                s.getId(),
                s.getTitle(),
                s.getDescription(),
                s.getScheduleTime()
        );
    }

    @Transactional
    public void deleteSchedule(Long id) {
        boolean exists = scheduleRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("해당 일정 id는 존재하지 않습니다.");
        }
        scheduleRepository.deleteById(id);
    }

}
