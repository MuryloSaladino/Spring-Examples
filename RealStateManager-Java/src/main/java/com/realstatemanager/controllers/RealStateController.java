package com.realstatemanager.controllers;

import com.realstatemanager.dto.realState.RealStateCreationPayload;
import com.realstatemanager.dto.realState.RealStateEntityResponse;
import com.realstatemanager.interfaces.RealStateService;
import com.realstatemanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/realState")
public class RealStateController {

    @Autowired
    UserSession userSession;

    @Autowired
    RealStateService realStateService;

    @PostMapping("")
    public ResponseEntity<RealStateEntityResponse> create(@Valid @RequestBody RealStateCreationPayload body) {

        userSession.verifyAdmin();

        return ResponseEntity
                .status(201)
                .body(new RealStateEntityResponse(realStateService.create(body)));
    }

    @GetMapping("")
    public ResponseEntity<List<RealStateEntityResponse>> getAll() {
        return ResponseEntity.ok(
                realStateService
                        .readAll()
                        .stream()
                        .map(x -> new RealStateEntityResponse(x))
                        .toList()
        );
    }
}
