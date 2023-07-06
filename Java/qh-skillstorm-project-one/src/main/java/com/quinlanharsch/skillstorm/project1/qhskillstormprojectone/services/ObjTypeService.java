package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.ObjType;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.repositories.ObjTypeRepository;

@Service
public class ObjTypeService {
    @Autowired
    ObjTypeRepository objTypeRepository;

    public ObjType saveObjType(ObjType objtype) {
        return objTypeRepository.save(objtype);
    }

    public ObjType findById(int id) {
        Optional<ObjType> objtype = objTypeRepository.findById(id);
        if(objtype.isPresent()) {
            return objtype.get();
        }
        return null;
    }
}
