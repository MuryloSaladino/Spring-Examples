package com.realstatemanager.dto.category;


import com.realstatemanager.entities.CategoryEntity;

public class CategoryResponse {

    public Long id;
    public String name;

    public CategoryResponse(CategoryEntity category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
