package com.realstatemanager.dto.user;

import com.realstatemanager.entities.UserEntity;
import com.realstatemanager.interfaces.EntityCreationPayload;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class UserCreationPayload implements EntityCreationPayload<UserEntity> {

    @NotEmpty(message = "You must provide a username")
    @Size(min = 4, message = "Username must have at least 4 characters")
    private String username;

    @NotEmpty(message = "You must provide a password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password is too week")
    private String password;

    @NotEmpty(message = "You must provide a name")
    @Size(min = 3, max = 255, message = "Name length must be between 3 and 255 characters")
    private String name;

    @NotEmpty(message = "You must provide a email")
    @Email(message = "Email must be valid")
    private String email;

    private String phone;

    private Boolean admin;

    @Override
    public UserEntity toEntity() {
        return new UserEntity(name, username, email, password, phone, admin);
    }
}
