package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.ObjType;

@Repository
public interface ObjTypeRepository extends JpaRepository<ObjType, Integer> {
    // save, findAll, findById, delete, deleteByID, deleteAll, etc.
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords 

}
