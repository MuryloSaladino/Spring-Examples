package com.realstatemanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Entity @Table()
public class AddressEntity extends BaseEntity {

    @Column()
    private String street;

    @Column()
    private String zipcode;

    @Column()
    private Integer number;

    @Column()
    private String city;

    @Column()
    private String state;

    @Getter @Setter
    @Column() @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;


    public AddressEntity() {}

    public AddressEntity(String street, String zipcode, Integer number, String city, String state) {
        super();
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
        this.city = city;
        this.state = state;
    }


    public void setStreet(String street) {
        this.updateUpdatedAt();
        this.street = street;
    }

    public void setZipcode(String zipcode) {
        this.updateUpdatedAt();
        this.zipcode = zipcode;
    }

    public void setNumber(Integer number) {
        this.updateUpdatedAt();
        this.number = number;
    }

    public void setCity(String city) {
        this.updateUpdatedAt();
        this.city = city;
    }

    public void setState(String state) {
        this.updateUpdatedAt();
        this.state = state;
    }
}
