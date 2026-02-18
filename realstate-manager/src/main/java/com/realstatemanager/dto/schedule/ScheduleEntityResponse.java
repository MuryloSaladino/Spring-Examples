package com.realstatemanager.dto.schedule;

import com.realstatemanager.dto.realState.RealStateEntityResponse;
import com.realstatemanager.dto.user.UserEntityResponse;
import com.realstatemanager.entities.ScheduleEntity;

import java.util.Date;

public class ScheduleEntityResponse {

    public Long id;
    public Date date;
    public RealStateEntityResponse realState;

    public ScheduleEntityResponse(ScheduleEntity scheduleEntity) {
        this.id = scheduleEntity.getId();
        this.date = scheduleEntity.getDate();
        this.realState = new RealStateEntityResponse(scheduleEntity.getRealStateEntity());
    }
}
