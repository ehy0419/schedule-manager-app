package com.schedulemanagerapp.controller;

import com.schedulemanagerapp.dto.ScheduleReponse;
import com.schedulemanagerapp.dto.ScheduleRequest;
import com.schedulemanagerapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/Scheules")
    public ScheduleReponse createSchedule(
            @RequestBody ScheduleRequest scheduleRequest
    )
}
