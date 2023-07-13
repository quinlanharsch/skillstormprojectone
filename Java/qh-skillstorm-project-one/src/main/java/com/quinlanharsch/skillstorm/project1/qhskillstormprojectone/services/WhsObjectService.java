package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.WhsObject;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.WhsObjectKey;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.repositories.WhsObjectRepository;

@Service
public class WhsObjectService {
     @Autowired
    WhsObjectRepository repository;

    // TODO: Warehouse UPDATE if CAPACITY CHANGES
    public WhsObject saveWhsObject(WhsObject whsObject) {
        whsObject.setDefaultLog();
        return repository.save(whsObject);
    }

    public WhsObject findById(int whsid, int typid) {
        WhsObjectKey key = new WhsObjectKey(whsid, typid);
        Optional<WhsObject> whsObject = repository.findById(key);
        if(whsObject.isPresent()) {
            return whsObject.get();
        }
        return null;
    }

    public WhsObject deleteById(int whsid, int typid) {
        WhsObjectKey key = new WhsObjectKey(whsid, typid);
        Optional<WhsObject> whsObject = repository.findById(key);
        if(whsObject.isPresent()) {
            repository.deleteById(whsid, typid);
            return whsObject.get();
        }
        return null;
    }
}
