package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.Warehouse;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.repositories.WarehouseRepository;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository repository;

    public Warehouse saveObjType(Warehouse objecttype) {
        return repository.save(objecttype);
    }
}
