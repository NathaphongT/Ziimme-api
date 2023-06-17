package com.ziimme.websource.repository;

import com.ziimme.websource.models.SaleEmployee;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleEmployeeRepository extends JpaRepository<SaleEmployee, Integer> {
  // List<SaleEmployee> findBySale(int sale_id);
  // @Transactional
  // void deleteBySaleId(int sale_id);
}