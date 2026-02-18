package com.realstatemanager.controllers;

import com.realstatemanager.dto.login.LoginPayload;
import com.realstatemanager.dto.login.LoginResponse;
import com.realstatemanager.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("")
    protected ResponseEntity<LoginResponse> login(@RequestBody LoginPayload payload) {
        String token = loginService.login(payload.username(), payload.password());

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
