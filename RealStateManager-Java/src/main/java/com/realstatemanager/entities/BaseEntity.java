package com.realstatemanager.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;


@MappedSuperclass @Getter
public class BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    protected Timestamp updatedAt;


    protected BaseEntity() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }


    public void updateUpdatedAt() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
