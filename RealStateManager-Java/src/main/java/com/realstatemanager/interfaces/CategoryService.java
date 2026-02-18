package com.realstatemanager.interfaces;

import com.realstatemanager.dto.category.CategoryCreationPayload;
import com.realstatemanager.entities.CategoryEntity;
import com.realstatemanager.entities.RealStateEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity create(CategoryCreationPayload payload);
    List<CategoryEntity> readAll();
}
