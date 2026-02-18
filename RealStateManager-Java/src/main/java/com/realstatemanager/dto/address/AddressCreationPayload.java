package com.realstatemanager.dto.address;

import com.realstatemanager.entities.AddressEntity;
import com.realstatemanager.interfaces.EntityCreationPayload;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class AddressCreationPayload implements EntityCreationPayload<AddressEntity> {

    @NotEmpty(message = "You must provide a street")
    @Size(min = 1, max = 45)
    private String street;

    @NotEmpty(message = "You must provide a zipcode")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Invalid Brazilian ZIP code format")
    private String zipcode;

    @NotNull(message = "You must provide a number")
    @Positive(message = "Number must be positive")
    private Integer number;

    @NotEmpty(message = "You must provide a city")
    @Size(max = 20)
    private String city;

    @NotEmpty(message = "You must provide a state")
    @Size(max = 2)
    private String state;

    @Override
    public AddressEntity toEntity() {
        return new AddressEntity(street, zipcode, number, city, state);
    }
}
