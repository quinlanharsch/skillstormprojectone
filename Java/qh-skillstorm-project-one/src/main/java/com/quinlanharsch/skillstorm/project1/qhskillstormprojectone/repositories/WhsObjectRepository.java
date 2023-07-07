package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.WhsObject;

@Repository
public interface WhsObjectRepository extends JpaRepository<WhsObject, Integer> {
    // save, findAll, findById, delete, deleteByID, deleteAll, etc.
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords 
    
    Optional<WhsObject> findById(int whsid, int typid);

    void deleteById(int whsid, int typid);

    // if this doesn't work use https://stackoverflow.com/questions/60622940/how-to-make-findby-with-composite-key-in-spring-data-jpa-hibernate-embedde
}
