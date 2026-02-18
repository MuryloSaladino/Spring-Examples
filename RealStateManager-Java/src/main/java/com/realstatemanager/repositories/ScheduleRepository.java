package com.realstatemanager.repositories;

import com.realstatemanager.entities.RealStateEntity;
import com.realstatemanager.entities.ScheduleEntity;
import com.realstatemanager.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Long> {
    List<ScheduleEntity> findScheduleEntitiesByRealStateEntity(RealStateEntity realStateEntity);
    List<ScheduleEntity> findScheduleEntitiesByUserEntity(UserEntity userEntity);
}
