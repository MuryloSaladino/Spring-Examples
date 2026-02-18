package com.realstatemanager.controllers;

import com.realstatemanager.dto.user.UserCreationPayload;
import com.realstatemanager.dto.user.UserEntityResponse;
import com.realstatemanager.dto.user.UserUpdatePayload;
import com.realstatemanager.entities.UserEntity;
import com.realstatemanager.exceptions.ForbiddenException;
import com.realstatemanager.interfaces.UserEntityService;
import com.realstatemanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/users")
public class UserController {

    @Autowired
    private UserEntityService userService;

    @Autowired
    private UserSession userSession;

    @PostMapping("")
    protected ResponseEntity<UserEntityResponse> createUser(@Valid @RequestBody UserCreationPayload body) {

        if(body.getAdmin()) userSession.verifyAdmin();

        return ResponseEntity.ok(new UserEntityResponse(userService.create(body)));
    }

    @GetMapping("/{id}")
    protected ResponseEntity<UserEntity> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.readById(id));
    }

    @GetMapping("")
    protected ResponseEntity<List<UserEntityResponse>> getAllUsers() {

        List<UserEntityResponse> users = userService
                .readAll()
                .stream()
                .map(UserEntityResponse::new)
                .toList();

        return ResponseEntity.ok(users);
    }

    @PatchMapping("/{id}")
    protected ResponseEntity<UserEntityResponse> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdatePayload body) {

        if(body.getAdmin() != null && body.getAdmin()) userSession.verifyAdmin();
        userSession.verifyOwnUserOrAdmin(id);

        return ResponseEntity.ok(new UserEntityResponse(userService.updateUser(id, body)));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<?> deleteUser(@PathVariable Long id) {

        userSession.verifyOwnUserOrAdmin(id);

        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}
