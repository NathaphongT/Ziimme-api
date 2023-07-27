package com.ziimme.websource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.Sale;
import com.ziimme.websource.models.SaleCut;

public interface SaleCutRepository extends JpaRepository<SaleCut, Integer>, JpaSpecificationExecutor<SaleCut> {
    @Query(value = "SELECT u FROM SaleCut u WHERE recordStatus = 'A' ORDER BY saleCutId")
    List<SaleCut> findAll();

    @Query(value = "SELECT d FROM SaleCut d WHERE recordStatus = 'A' AND saleProductId = :id  ORDER BY saleCutId DESC")
    List<SaleCut> findByIdCut(@Param("id") int saleProductId);
}
