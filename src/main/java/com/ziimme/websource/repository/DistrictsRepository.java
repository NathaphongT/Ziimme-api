package com.ziimme.websource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.Districts;

public interface DistrictsRepository extends JpaRepository<Districts, Integer>, JpaSpecificationExecutor<Districts> {

    @Query(value = "SELECT u FROM Districts u  ORDER BY districts_id")
    List<Districts> findAll();

    @Query(value = "SELECT d FROM Districts d WHERE province_code = :id ")
    List<Districts> findById(@Param("id") int province_code);
}
