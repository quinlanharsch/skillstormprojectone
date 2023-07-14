package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.WhsObject;
import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.WhsObjectKey;

@Repository
public interface WhsObjectRepository extends JpaRepository<WhsObject, Integer> {
    // save, findAll, findById, delete, deleteByID, deleteAll, etc.
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords 

    // FIND
    Optional<WhsObject> findById(WhsObjectKey id);
    
    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM public.WhsObjects o where o.WhsId = ?1 and o.TypId = ?2 ;", nativeQuery = true)
    void deleteById(int whsid, int typid);

    // WhsObjKey from https://stackoverflow.com/questions/60622940/how-to-make-findby-with-composite-key-in-spring-data-jpa-hibernate-embedde
}
