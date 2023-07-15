package com.ziimme.websource.repository;

import com.ziimme.websource.models.Sale;
import com.ziimme.websource.models.SaleEmployee;
import com.ziimme.websource.models.Users;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SaleEmployeeRepository extends JpaRepository<SaleEmployee, Integer> {
  List<SaleEmployee> findBySaleId(int saleId);

  @Transactional
  void deleteBySaleId(int saleId);
}