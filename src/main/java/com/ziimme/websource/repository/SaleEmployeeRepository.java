package com.ziimme.websource.repository;

import com.ziimme.websource.models.Sale;
import com.ziimme.websource.models.SaleEmployee;
import com.ziimme.websource.models.Users;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleEmployeeRepository extends JpaRepository<SaleEmployee, Integer> {
  // List<SaleEmployee> findBySale(int consultant_id);
  // @Transactional
  // void deleteBySaleId(int sale_id);

  // @Query(value = "SELECT u FROM SaleEmployee u WHERE recordStatus = 'A' ORDER BY sale_id")
  // List<SaleEmployee> findById();

  @Query(value = "SELECT d FROM SaleEmployee d WHERE  sale_id = :id ")
  List<SaleEmployee> findByIdSale(@Param("id") int sale_id);

  @Query(value = "SELECT d FROM SaleEmployee d WHERE  consultant_id = :id ")
  List<SaleEmployee> findByIdConsultant(@Param("id") int consultant_id);

}