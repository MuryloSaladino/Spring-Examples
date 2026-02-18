package com.realstatemanager.services;

import com.realstatemanager.dto.realState.RealStateCreationPayload;
import com.realstatemanager.entities.RealStateEntity;
import com.realstatemanager.exceptions.NotFoundException;
import com.realstatemanager.interfaces.RealStateService;
import com.realstatemanager.repositories.AddressRepository;
import com.realstatemanager.repositories.CategoryRepository;
import com.realstatemanager.repositories.RealStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealStateServiceDefault implements RealStateService {

    @Autowired
    private RealStateRepository realStateRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public RealStateEntity create(RealStateCreationPayload payload) {

        var query = categoryRepository.findById(payload.getCategoryId());
        if(query.isEmpty()) throw new NotFoundException();

        var address = addressRepository.save(payload.getAddress().toEntity());

        RealStateEntity realStateEntity = payload.toEntity();
        realStateEntity.setCategory(query.get());
        realStateEntity.setAddress(address);

        return realStateRepository.save(realStateEntity);
    }

    @Override
    public List<RealStateEntity> readAll() {
        return (List<RealStateEntity>) realStateRepository.findAll();
    }

    @Override
    public List<RealStateEntity> readByCategory(Long id) {

        var query = categoryRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        return realStateRepository.findByCategory(query.get());
    }
}
