package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.ObjType;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.repositories.ObjTypeRepository;

@Service
public class ObjTypeService {
    @Autowired
    ObjTypeRepository objTypeRepository;

    public List<ObjType> findAllObjTypes() {
        return objTypeRepository.findAll();
    }

    public ObjType saveObjType(ObjType objtype) {
        objtype.setDefaultLog();
        return objTypeRepository.save(objtype);
    }

    public ObjType findById(int typid) {
        Optional<ObjType> objtype = objTypeRepository.findById(typid);
        if(objtype.isPresent()) {
            return objtype.get();
        }
        return null;
    }

    public ObjType deleteById(int typid) {
        Optional<ObjType> objtype = objTypeRepository.findById(typid);
        if(objtype.isPresent()) {
            objTypeRepository.deleteById(typid);
            return objtype.get();
        }
        return null;
    }
}
