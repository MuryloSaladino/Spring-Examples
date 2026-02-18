package com.realstatemanager.interfaces;

import com.realstatemanager.dto.schedule.ScheduleEntityCreationPayload;
import com.realstatemanager.entities.ScheduleEntity;

import java.util.List;

public interface ScheduleService {
    ScheduleEntity create(ScheduleEntityCreationPayload payload, Long realStateId);
    ScheduleEntity getById(Long id);
    List<ScheduleEntity> getByUser();
    List<ScheduleEntity> getByRealState(Long realStateId);
}
