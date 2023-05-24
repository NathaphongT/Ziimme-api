package com.ziimme.websource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ziimme.websource.models.SaleCut;

public interface SaleCutRepository extends JpaRepository<SaleCut, Integer>, JpaSpecificationExecutor<SaleCut> {

    @Query(value = "SELECT u FROM SaleCut u WHERE record_status = 'A' ORDER BY sale_cut_id")
    List<SaleCut> findAll();

}
