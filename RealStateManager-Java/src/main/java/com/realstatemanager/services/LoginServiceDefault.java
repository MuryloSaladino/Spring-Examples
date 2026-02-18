package com.realstatemanager.services;

import com.realstatemanager.exceptions.NotFoundException;
import com.realstatemanager.exceptions.UnauthorizedException;
import com.realstatemanager.interfaces.JwtTokenManager;
import com.realstatemanager.interfaces.LoginService;
import com.realstatemanager.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceDefault implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenManager jwtTokenManager;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @Override
    public String login(String username, String password) {

        var userQuery = userRepository.findByUsername(username);
        if(userQuery.isEmpty()) throw new NotFoundException();

        var match = encoder.matches(password, userQuery.get().getPassword());

        if(!match) throw new UnauthorizedException();

        Map<String, Object> claims = new HashMap<>();
        claims.put("admin", userQuery.get().getAdmin());

        return jwtTokenManager.buildToken(claims, userQuery.get().getUsername(), userQuery.get().getId());
    }
}
