package com.realstatemanager.dto.category;


import com.realstatemanager.entities.CategoryEntity;
import com.realstatemanager.interfaces.EntityCreationPayload;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class CategoryCreationPayload implements EntityCreationPayload<CategoryEntity> {

    @NotEmpty(message = "You must provide a name")
    private String name;

    @Override
    public CategoryEntity toEntity() {
        return new CategoryEntity(name);
    }
}
