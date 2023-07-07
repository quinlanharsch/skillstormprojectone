package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.WhsObject;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.WhsObjectKey;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.services.WhsObjectService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/objects")
public class WhsObjectController {
    
    @Autowired
    WhsObjectService whsObjectService;

    //Create
    @PostMapping("/object")
    public ResponseEntity<WhsObject> createWhsObject(WhsObject whsObject) {
        WhsObject newWhsObject = whsObjectService.saveWhsObject(whsObject);
        return new ResponseEntity<WhsObject>(newWhsObject, HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/object/{whsid}/{typid}")
    public ResponseEntity<WhsObject> findWhsObjectById(int whsid, int typid) {
        WhsObject whsObject = whsObjectService.findById(whsid, typid);
        return new ResponseEntity<WhsObject>(whsObject, HttpStatus.OK);
    }

    //Update
    @PutMapping("/object")
    public ResponseEntity<WhsObject> updateWhsObject(@RequestBody WhsObject whsObject) {
        WhsObject newWhsObject = whsObjectService.saveWhsObject(whsObject);
        return new ResponseEntity<WhsObject>(newWhsObject, HttpStatus.OK);
    }

    //Delete 
    @DeleteMapping("/object/{whsid}/{typid}")
    public ResponseEntity<WhsObject> deleteWhsObject(int whsid, int typid) {
        WhsObject delWhsObject = whsObjectService.deleteById(whsid, typid);
        return new ResponseEntity<WhsObject>(delWhsObject, HttpStatus.NO_CONTENT);
    }
}
