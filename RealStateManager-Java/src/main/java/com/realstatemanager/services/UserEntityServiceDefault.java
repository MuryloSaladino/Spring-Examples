package com.realstatemanager.services;

import com.realstatemanager.dto.user.UserCreationPayload;
import com.realstatemanager.dto.user.UserUpdatePayload;
import com.realstatemanager.entities.UserEntity;
import com.realstatemanager.exceptions.NotFoundException;
import com.realstatemanager.interfaces.UserEntityService;
import com.realstatemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityServiceDefault implements UserEntityService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserEntity create(UserCreationPayload payload) {

        UserEntity newUser = payload.toEntity();
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

        return userRepository.save(newUser);
    }

    @Override
    public List<UserEntity> readAll() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public UserEntity readById(Long id) {

        var userQuery = userRepository.findById(id);
        if(userQuery.isEmpty()) throw new NotFoundException();

        return userQuery.get();
    }

    @Override
    public UserEntity updateUser(Long id, UserUpdatePayload payload) {

        var query = userRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        UserEntity user = query.get();

        if(payload.getEmail() != null) user.setEmail(payload.getEmail());
        if(payload.getName() != null) user.setName(payload.getName());
        if(payload.getPhone() != null) user.setPhone(payload.getPhone());
        if(payload.getAdmin() != null) user.setAdmin(payload.getAdmin());
        if(payload.getUsername() != null) user.setUsername(payload.getUsername().replaceAll("//s", ""));
        if(payload.getPassword() != null) user.setPassword(bCryptPasswordEncoder.encode(payload.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {

        var userQuery = userRepository.findById(id);
        if(userQuery.isEmpty()) throw new NotFoundException();

        userRepository.deleteById(id);
    }
}
