package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.ObjType;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.services.ObjTypeService;

@RestController
@RequestMapping("/types")
public class ObjTypeController {
    
    @Autowired
    ObjTypeService objTypeService;

    //Create

    
    //Read
    @GetMapping("/types/{typid}")
    public ResponseEntity<ObjType> findMovieById(@PathVariable int typid) {
        ObjType objtype = objTypeService.findById(typid);
        return new ResponseEntity<ObjType>(objtype, HttpStatus.OK);
    }
    
    //Upadate
    
    //Delete
    
}
