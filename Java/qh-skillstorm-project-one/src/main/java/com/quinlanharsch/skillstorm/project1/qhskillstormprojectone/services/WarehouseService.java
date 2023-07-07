package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.Warehouse;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.repositories.WarehouseRepository;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository repository;

    public Warehouse saveWarehouse(Warehouse warehouse) {
        return repository.save(warehouse);
    }

    public Warehouse findById(int id) {
        Optional<Warehouse> warehouse = repository.findById(id);
        if(warehouse.isPresent()) {
            return warehouse.get();
        }
        return null;
    }

    public Warehouse deleteById(int id) {
        Optional<Warehouse> warehouse = repository.findById(id);
        if(warehouse.isPresent()) {
            repository.deleteById(id);
            return warehouse.get();
        }
        return null;
    }
}
