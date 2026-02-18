package com.realstatemanager.repositories;

import com.realstatemanager.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealStateCategoryRepository extends JpaRepository<CategoryEntity, Long> { }
