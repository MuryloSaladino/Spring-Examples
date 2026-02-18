package com.realstatemanager.dto.realState;

import com.realstatemanager.dto.address.AddressCreationPayload;
import com.realstatemanager.entities.RealStateEntity;
import com.realstatemanager.interfaces.EntityCreationPayload;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class RealStateCreationPayload implements EntityCreationPayload<RealStateEntity> {

    @NotNull(message = "You must provide a price")
    @Positive(message = "Price must have a positive value")
    private Float price;

    @AssertFalse
    private Boolean sold;

    @NotNull(message = "You must provide a value for the squared meters")
    @Positive(message = "Squared meters must have a positive value")
    private Integer squaredMeters;

    @Valid
    private AddressCreationPayload address;

    @NotNull(message = "You must provide a category id")
    @Positive(message = "Category id must be a positive number")
    private Long categoryId;


    @Override
    public RealStateEntity toEntity() {
        return new RealStateEntity(sold, price, squaredMeters);
    }
}
