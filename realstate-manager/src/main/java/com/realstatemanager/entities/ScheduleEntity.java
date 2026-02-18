package com.realstatemanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Getter @Entity @Table()
public class ScheduleEntity extends BaseEntity {

    @Column()
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "userEntityId", nullable = false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "realStateEntityId", nullable = false)
    private RealStateEntity realStateEntity;

    @Setter
    @Column() @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;


    public ScheduleEntity() {}

    public ScheduleEntity(Date date) {
        super();
        this.date = date;
    }


    public void setDate(Date date) {
        this.updateUpdatedAt();
        this.date = date;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.updateUpdatedAt();
        this.userEntity = userEntity;
    }

    public void setRealStateEntity(RealStateEntity realStateEntity) {
        this.updateUpdatedAt();
        this.realStateEntity = realStateEntity;
    }
}
