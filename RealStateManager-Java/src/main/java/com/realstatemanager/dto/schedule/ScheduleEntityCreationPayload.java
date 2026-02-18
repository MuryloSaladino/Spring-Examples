package com.realstatemanager.dto.schedule;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.realstatemanager.entities.ScheduleEntity;
import com.realstatemanager.interfaces.EntityCreationPayload;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;

public class ScheduleEntityCreationPayload implements EntityCreationPayload<ScheduleEntity> {

    @NotNull
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date date;

    public ScheduleEntity toEntity() {
        return new ScheduleEntity(date);
    }
}
