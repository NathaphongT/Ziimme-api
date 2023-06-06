package com.ziimme.websource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.SaleCut;

public interface SaleCutRepository extends JpaRepository<SaleCut, Integer>, JpaSpecificationExecutor<SaleCut> {

    @Query(value = "SELECT u FROM SaleCut u WHERE record_status = 'A' ORDER BY sale_id")
    List<SaleCut> findAll();

    @Query(value = "SELECT d FROM SaleCut d WHERE record_status = 'A' AND sale_id = :id ")
    List<SaleCut> findByIdSaleCut(@Param("id") int sale_id);

    @Query(value = "SELECT  d FROM SaleCut d WHERE sale_id = :id ORDER BY created_time DESC")
    List<SaleCut> findIdSaleCutOrder(@Param("id") int sale_id);
  

}
