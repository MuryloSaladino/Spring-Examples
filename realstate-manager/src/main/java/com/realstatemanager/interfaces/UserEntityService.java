package com.realstatemanager.interfaces;

import com.realstatemanager.dto.user.UserCreationPayload;
import com.realstatemanager.dto.user.UserUpdatePayload;
import com.realstatemanager.entities.UserEntity;

import java.util.List;

public interface UserEntityService {
    UserEntity create(UserCreationPayload payload);
    List<UserEntity> readAll();
    UserEntity readById(Long id);
    UserEntity updateUser(Long id, UserUpdatePayload payload);
    void deleteUser(Long id);
}
