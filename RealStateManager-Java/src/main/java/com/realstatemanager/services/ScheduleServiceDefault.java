package com.realstatemanager.services;

import com.realstatemanager.dto.schedule.ScheduleEntityCreationPayload;
import com.realstatemanager.entities.ScheduleEntity;
import com.realstatemanager.exceptions.NotFoundException;
import com.realstatemanager.interfaces.ScheduleService;
import com.realstatemanager.repositories.RealStateRepository;
import com.realstatemanager.repositories.ScheduleRepository;
import com.realstatemanager.repositories.UserRepository;
import com.realstatemanager.sessions.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceDefault implements ScheduleService {

    @Autowired
    UserSession userSession;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RealStateRepository realStateRepository;


    @Override
    public ScheduleEntity create(ScheduleEntityCreationPayload payload, Long realStateId) {

        var userQuery = userRepository.findById(userSession.getId());
        if(userQuery.isEmpty()) throw new NotFoundException();

        var realStateQuery = realStateRepository.findById(realStateId);
        if(realStateQuery.isEmpty()) throw new NotFoundException();

        ScheduleEntity scheduleEntity = payload.toEntity();
        scheduleEntity.setUserEntity(userQuery.get());
        scheduleEntity.setRealStateEntity(realStateQuery.get());

        return scheduleRepository.save(scheduleEntity);
    }

    @Override
    public ScheduleEntity getById(Long id) {

        var query = scheduleRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        return query.get();
    }

    @Override
    public List<ScheduleEntity> getByRealState(Long realStateId) {

        var realStateQuery = realStateRepository.findById(realStateId);
        if(realStateQuery.isEmpty()) throw new NotFoundException();

        return scheduleRepository.findScheduleEntitiesByRealStateEntity(realStateQuery.get());
    }

    @Override
    public List<ScheduleEntity> getByUser() {

        var userQuery = userRepository.findById(userSession.getId());
        if(userQuery.isEmpty()) throw new NotFoundException();

        return scheduleRepository.findScheduleEntitiesByUserEntity(userQuery.get());
    }
}
