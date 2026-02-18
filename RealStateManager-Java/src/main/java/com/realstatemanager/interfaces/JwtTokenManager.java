package com.realstatemanager.interfaces;

import com.realstatemanager.exceptions.UnauthorizedException;
import io.jsonwebtoken.Claims;

import java.util.Map;

public interface JwtTokenManager {
    Claims extractClaims(String token) throws UnauthorizedException;
    boolean isTokenValid(String token);
    String buildToken(Map<String, Object> claims, String subject, Long userId);
}
