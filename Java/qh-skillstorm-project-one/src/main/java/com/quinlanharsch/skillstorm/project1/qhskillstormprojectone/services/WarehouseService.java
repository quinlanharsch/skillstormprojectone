package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.Warehouse;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.repositories.WarehouseRepository;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public List<Warehouse> findAllWarehouses() {
        return warehouseRepository.findAll();
    }

    // TODO: Warehouse UPDATE if CAPACITY CHANGES
    public Warehouse saveWarehouse(Warehouse warehouse) {
        warehouse.setDefaultLog();
        return warehouseRepository.save(warehouse);
    }

    public Warehouse findById(int id) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);
        if(warehouse.isPresent()) {
            return warehouse.get();
        }
        return null;
    }

    public Warehouse deleteById(int id) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);
        if(warehouse.isPresent()) {
            warehouseRepository.deleteById(id);
            return warehouse.get();
        }
        return null;
    }
}
