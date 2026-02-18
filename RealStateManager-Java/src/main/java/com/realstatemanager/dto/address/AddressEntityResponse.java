package com.realstatemanager.dto.address;


import com.realstatemanager.entities.AddressEntity;

public class AddressEntityResponse {

    public String street;
    public String zipcode;
    public Integer number;
    public String city;
    public String state;

    public AddressEntityResponse(AddressEntity addressEntity) {
        this.street = addressEntity.getStreet();
        this.zipcode = addressEntity.getZipcode();
        this.number = addressEntity.getNumber();
        this.city = addressEntity.getCity();
        this.state = addressEntity.getState();
    }
}
