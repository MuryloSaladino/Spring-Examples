package com.realstatemanager.repositories;

import com.realstatemanager.entities.CategoryEntity;
import com.realstatemanager.entities.RealStateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RealStateRepository extends CrudRepository<RealStateEntity, Long> {
    List<RealStateEntity> findByCategory(CategoryEntity category);
}
