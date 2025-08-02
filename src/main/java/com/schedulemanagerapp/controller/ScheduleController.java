package com.schedulemanagerapp.controller;

import com.schedulemanagerapp.dto.ScheduleResponse;
import com.schedulemanagerapp.dto.ScheduleRequest;
import com.schedulemanagerapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ScheduleResponse createSchedule(
            @RequestBody ScheduleRequest scheduleRequest
    ) {
        return scheduleService.save(scheduleRequest);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponse> getSchedules() {
        return scheduleService.findSchedules();
    }

    @GetMapping("/schedules/{scheduleId}")
    public ScheduleResponse getSchedule(
            @PathVariable Long scheduleId
    ) {
        return scheduleService.findSchedule(scheduleId);
    }

    @PutMapping("/schedules/{scheduleId}")
    public ScheduleResponse updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleRequest scheduleRequest
    ) {
        return scheduleService.update(scheduleId, scheduleRequest);
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public void deleteSchedule(
            @PathVariable Long scheduleId
    ) {
        scheduleService.deleteSchedule(scheduleId);
    }

}
