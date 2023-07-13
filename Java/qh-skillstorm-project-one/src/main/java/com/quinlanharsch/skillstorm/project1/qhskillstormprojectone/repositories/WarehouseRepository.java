package com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quinlanharsch.skillstorm.project1.qhskillstormprojectone.models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{
    // save, findAll, findById, delete, deleteByID, deleteAll, etc.
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords 

    // DELETE FROM BOTH WAREHOUSE AND WHSOBJECTS
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM public.WhsObjects o where o.WhsId = ?1 ;\r\n" + //
                   "DELETE FROM public.Warehouses w WHERE w.WhsId = ?1 ;", nativeQuery = true)
    void deleteById(int whsid);

    @Query(value = "SELECT MAX(w.capacity) - SUM(t.size * o.quantity) CapSum\r\n" + //
            "FROM public.Warehouses w\r\n" + //
            "JOIN public.WhsObjects o ON w.WhsId = o.WhsId\r\n" + //
            "JOIN public.ObjTypes t on t.TypId = o.TypId\r\n" + //
            "WHERE w.WhsId = ?1 ;", nativeQuery = true)
    BigDecimal remainingCapacityByWhsId(int whsid);
}
