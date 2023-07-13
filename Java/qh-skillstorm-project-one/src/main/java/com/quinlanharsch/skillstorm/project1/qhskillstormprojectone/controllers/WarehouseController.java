package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.Warehouse;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.services.WarehouseService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    
    @Autowired
    WarehouseService warehouseService;

    //Create
    @PostMapping("/warehouse")
    public ResponseEntity<Warehouse> createWarehouse(@Valid @RequestBody Warehouse warehouse) {
        Warehouse newWarehouse = warehouseService.saveWarehouse(warehouse);
        return new ResponseEntity<Warehouse>(newWarehouse, HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/warehouse/{whsid}")
    public ResponseEntity<Warehouse> findWarehouseById(@PathVariable int whsid) {
        Warehouse warehouse = warehouseService.findById(whsid);
        return new ResponseEntity<Warehouse>(warehouse, HttpStatus.OK);
    }

    //Update
    @PutMapping("/warehouse")
    public ResponseEntity<Warehouse> updateWarehouse(@Valid @RequestBody Warehouse warehouse) {
        Warehouse newWarehouse = warehouseService.saveWarehouse(warehouse);
        return new ResponseEntity<Warehouse>(newWarehouse, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/warehouse/{whsid}")
    public ResponseEntity<Warehouse> deleteWarehouse(@PathVariable int whid) {
        Warehouse delWarehouse = warehouseService.deleteById(whid);
        return new ResponseEntity<Warehouse>(delWarehouse, HttpStatus.NO_CONTENT);
    }
}
