package com.realstatemanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter @Entity @Table()
public class CategoryEntity extends BaseEntity {

    @Column()
    private String name;

    @Getter @Setter
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;


    public CategoryEntity() {}

    public CategoryEntity(String name) {
        super();
        this.name = name;
    }


    public void setName(String name) {
        this.updateUpdatedAt();
        this.name = name;
    }
}
