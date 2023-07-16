package com.ziimme.websource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.SaleAllEmp;

public interface SaleAllEmpRepository extends JpaRepository<SaleAllEmp, Integer> {
     @Override
     @Query(value = "SELECT w FROM SaleAllEmp w")
     List<SaleAllEmp> findAll();

     @Query(value = "SELECT w FROM SaleAllEmp w WHERE empId = :id ")
     List<SaleAllEmp> findByIdSaleAllEmp(@Param("id") int empId);
}