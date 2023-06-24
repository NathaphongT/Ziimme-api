package com.ziimme.websource.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.Branch;
import com.ziimme.websource.models.Position;

public interface PositionRepository extends JpaRepository<Position, Integer>, JpaSpecificationExecutor<Position> {

    @Query(value = "SELECT fc FROM Employee fc WHERE recordStatus = 'A' ORDER BY positionId")
    List<Position> findAll();
    Page<Position> findAll(Specification<Position> specification, Pageable pageable);

}
