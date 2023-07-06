package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.WhsObject;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.repositories.WhsObjectRepository;

@Service
public class WhsObjectService {
     @Autowired
    WhsObjectRepository repository;

    public WhsObject saveObjType(WhsObject objecttype) {
        return repository.save(objecttype);
    }
}
