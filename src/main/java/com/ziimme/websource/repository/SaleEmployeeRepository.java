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
  // List<SaleEmployee> findBySale(int consultantId);
  // @Transactional
  // void deleteBySaleId(int saleId);

  // @Query(value = "SELECT u FROM SaleEmployee u WHERE recordStatus = 'A' ORDER
  // BY saleId")
  // List<SaleEmployee> findById();

  @Query(value = "SELECT d FROM SaleEmployee d WHERE  saleId = :id ")
  List<SaleEmployee> findByIdSale(@Param("id") int saleId);

  @Query(value = "SELECT d FROM SaleEmployee d WHERE  empId = :id ")
  List<SaleEmployee> findByIdEmp(@Param("id") int empId);

  @Query(value = "SELECT d FROM SaleEmployee d WHERE  cusId = :id ")
  List<SaleEmployee> findByIdCus(@Param("id") int cusId);

  @Query(value = "SELECT d FROM SaleEmployee d WHERE  consultantId = :id ")
  List<SaleEmployee> findByIdConsultant(@Param("id") int consultantId);

}