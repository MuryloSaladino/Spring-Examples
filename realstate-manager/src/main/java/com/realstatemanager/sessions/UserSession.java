package com.realstatemanager.sessions;

import com.realstatemanager.exceptions.ForbiddenException;
import com.realstatemanager.exceptions.UnauthorizedException;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSession {
    private Long id;
    private Boolean admin;

    public UserSession(Long id, Boolean admin) {
        this.id = id;
        this.admin = admin;
    }

    public void verifyAdmin() {
        verifyToken();
        if(!admin) throw new ForbiddenException();
    }

    public void verifyToken() {
        if(id == null) throw new UnauthorizedException();
    }

    public void verifyOwnUserOrAdmin(Long userId) {
        if(id == null) throw new UnauthorizedException();
        if(id.equals(userId)) return;
        if(!admin) throw new ForbiddenException();
    }
}
