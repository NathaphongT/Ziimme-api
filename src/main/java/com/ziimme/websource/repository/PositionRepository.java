package com.ziimme.websource.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.Position;

public interface PositionRepository extends JpaRepository<Position, Integer>, JpaSpecificationExecutor<Position> {

    @Query(value = "SELECT u FROM Position u WHERE recordStatus = 'A' ORDER BY position_id")
    List<Position> findAll();

    @Query(value = "SELECT u FROM Position u WHERE position_name = :position_name AND recordStatus = 'A'")
    Optional<Position> findByposition_name(@Param("position_name") String position_name);

    @Query(value = "SELECT u FROM Position u WHERE position_name = :position_name AND recordStatus = 'A'")
    Optional<Position> findposition_name(@Param("position_name") String position_name);

}
