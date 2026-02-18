package com.realstatemanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter @Entity @Table()
public class UserEntity extends BaseEntity {

    @Column()
    private String name;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column()
    private String password;

    @Column(unique = true)
    private String phone;

    @Column()
    private Boolean admin;

    @Setter
    @Column() @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;


    public UserEntity() {}

    public UserEntity(String name, String username, String email, String password, String phone, Boolean admin) {
        super();
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.admin = admin != null ? admin : false;
    }


    public void setName(String name) {
        this.updateUpdatedAt();
        this.name = name;
    }

    public void setUsername(String username) {
        this.updateUpdatedAt();
        this.username = username;
    }

    public void setEmail(String email) {
        this.updateUpdatedAt();
        this.email = email;
    }

    public void setPassword(String password) {
        this.updateUpdatedAt();
        this.password = password;
    }

    public void setPhone(String phone) {
        this.updateUpdatedAt();
        this.phone = phone;
    }

    public void setAdmin(Boolean admin) {
        this.updateUpdatedAt();
        this.admin = admin;
    }
}
