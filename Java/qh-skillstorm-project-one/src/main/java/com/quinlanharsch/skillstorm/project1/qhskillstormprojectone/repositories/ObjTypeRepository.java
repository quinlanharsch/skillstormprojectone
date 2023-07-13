package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.ObjType;

@Repository
public interface ObjTypeRepository extends JpaRepository<ObjType, Integer> {
    // save, findAll, findById, delete, deleteByID, deleteAll, etc.
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords 

    // DELETE FROM BOTH WAREHOUSE AND WHSOBJECTS
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM public.WhsObjects o where o.TypId = ?1 ;\r\n" + //
                   "DELETE FROM public.ObjTypes t WHERE t.TypId = ?1 ;", nativeQuery = true)
    void deleteById(int typid);
}
