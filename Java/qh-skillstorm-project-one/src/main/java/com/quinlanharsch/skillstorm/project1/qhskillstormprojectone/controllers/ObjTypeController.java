package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.ObjType;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.services.ObjTypeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/types")
public class ObjTypeController {
    
    @Autowired
    ObjTypeService objTypeService;

    //Create
    @PostMapping("/type") 
    public ResponseEntity<ObjType> createObjType(@Valid @RequestBody ObjType objType) {     
        ObjType newObjType = objTypeService.saveObjType(objType);
        return new ResponseEntity<ObjType>(newObjType, HttpStatus.CREATED);
    }
    
    //Read
    @GetMapping
    public ResponseEntity<List<ObjType>> findAllObjTypes() {
        List<ObjType> objTypes = objTypeService.findAllObjTypes();
        return new ResponseEntity<List<ObjType>>(objTypes, HttpStatus.OK);
    }

    @GetMapping("/type/{typid}")
    public ResponseEntity<ObjType> findObjTypeById(@PathVariable int typid) {
        ObjType objType = objTypeService.findById(typid);
        return new ResponseEntity<ObjType>(objType, HttpStatus.OK);
    }
    
    //Upadate
    @PutMapping("/type") 
    public ResponseEntity<ObjType> updateObjType(@Valid @RequestBody ObjType objType) {  
        ObjType newObjType = objTypeService.saveObjType(objType);
        return new ResponseEntity<ObjType>(newObjType, HttpStatus.OK);
    }
    
    //Delete
    @DeleteMapping("/type/{typid}")
    public ResponseEntity<ObjType> deleteById(@PathVariable int typid) {
        ObjType delObjType = objTypeService.deleteById(typid);
        return new ResponseEntity<ObjType>(delObjType, HttpStatus.NO_CONTENT);
    }
}
