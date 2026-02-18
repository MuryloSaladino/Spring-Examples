package com.realstatemanager.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class UserUpdatePayload {

    @Size(min = 4, message = "Username must have at least 4 characters")
    private String username;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password is too week")
    private String password;

    @Size(max = 255, message = "Name length cannot be above 255 characters")
    private String name;

    @Email(message = "Email must be valid")
    private String email;

    private String phone;

    private Boolean admin;
}
