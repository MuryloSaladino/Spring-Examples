package com.realstatemanager.dto.user;

import com.realstatemanager.entities.UserEntity;

public class UserEntityResponse {

    public Long id;
    public String username;
    public String name;
    public String email;
    public String phone;
    public Boolean admin;


    public UserEntityResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
        this.phone = userEntity.getPhone();
        this.admin = userEntity.getAdmin();
    }
}
