package com.ziimme.websource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.SubDistricts;

public interface SubDistrictsRepository
        extends JpaRepository<SubDistricts, Integer>, JpaSpecificationExecutor<SubDistricts> {

    @Query(value = "SELECT u FROM SubDistricts u ORDER BY sub_districts_id")
    List<SubDistricts> findAll();

    @Query(value = "SELECT d FROM SubDistricts d WHERE  districts_code = :id ")
    List<SubDistricts> findById(@Param("id") int districts_code);


    @Query(value = "SELECT d FROM SubDistricts d WHERE sub_districts_id = :id ")
    List<SubDistricts> findByIdSub(@Param("id") int sub_districts_id);

}
