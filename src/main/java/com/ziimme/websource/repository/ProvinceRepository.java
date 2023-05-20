package com.ziimme.websource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.Province;

public interface ProvinceRepository extends JpaRepository<Province, Integer>, JpaSpecificationExecutor<Province> {

    @Query(value = "SELECT u FROM Province u WHERE record_status = 'A' ORDER BY province_id")
    List<Province> findAll();

    @Query(value = "SELECT d FROM Province d WHERE record_status = 'A' AND province_id = :id ")
    List<Province> findById(@Param("id") int province_id);
}