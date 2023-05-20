package com.ziimme.websource.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer>, JpaSpecificationExecutor<Branch> {

    @Query(value = "SELECT u FROM Branch u WHERE recordStatus = 'A' ORDER BY branch_id")
    List<Branch> findAll();

    @Query(value = "SELECT u FROM Branch u WHERE branch_name = :branch_name AND recordStatus = 'A'")
    Optional<Branch> findBybranch_name(@Param("branch_name") String branch_name);

    @Query(value = "SELECT u FROM Branch u WHERE branch_name = :branch_name AND recordStatus = 'A'")
    Optional<Branch> findbranch_name(@Param("branch_name") String branch_name);

}
