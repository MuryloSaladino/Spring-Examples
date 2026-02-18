package com.realstatemanager.interfaces;

import com.realstatemanager.dto.realState.RealStateCreationPayload;
import com.realstatemanager.entities.CategoryEntity;
import com.realstatemanager.entities.RealStateEntity;

import java.util.List;

public interface RealStateService {
    RealStateEntity create(RealStateCreationPayload payload);
    List<RealStateEntity> readAll();
    List<RealStateEntity> readByCategory(Long id);
}
