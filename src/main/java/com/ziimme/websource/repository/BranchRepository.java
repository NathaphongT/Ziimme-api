package com.ziimme.websource.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ziimme.websource.models.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer>, JpaSpecificationExecutor<Branch> {
    @Query(value = "SELECT fc FROM Employee fc WHERE recordStatus = 'A' ORDER BY branch_id")
    List<Branch> findAll();
    Page<Branch> findAll(Specification<Branch> specification, Pageable pageable);
  
}
