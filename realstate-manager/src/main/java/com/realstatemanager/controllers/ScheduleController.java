package com.realstatemanager.controllers;

import com.realstatemanager.dto.schedule.ScheduleEntityCreationPayload;
import com.realstatemanager.dto.schedule.ScheduleEntityResponse;
import com.realstatemanager.interfaces.ScheduleService;
import com.realstatemanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    UserSession userSession;


    @PostMapping("/realState/{id}")
    protected ResponseEntity<ScheduleEntityResponse> createSchedule(
            @PathVariable Long id,
            @Valid @RequestBody ScheduleEntityCreationPayload body
    ) {
        userSession.verifyToken();

        return ResponseEntity.status(201).body(new ScheduleEntityResponse( scheduleService.create(body, id) ));
    }

    @GetMapping("/realState/{id}")
    public ResponseEntity<List<ScheduleEntityResponse>> getByRealState(@PathVariable Long id){
        userSession.verifyToken();

        return ResponseEntity.ok(scheduleService
                .getByRealState(id)
                .stream()
                .map(ScheduleEntityResponse::new)
                .toList());
    }
}
