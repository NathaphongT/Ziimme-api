package com.ziimme.websource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ziimme.websource.models.SalePay;

@Repository
public interface SalePaymentRepository extends JpaRepository<SalePay, Integer> {

     @Query(value = "SELECT w FROM SalePay w WHERE recordStatus = 'A' ORDER BY salePayId DESC")
     List<SalePay> findAll();

     @Query(value = "SELECT d FROM SalePay d WHERE recordStatus = 'A' AND saleProductId = :id  ORDER BY salePayId")
     List<SalePay> findByIdCut(@Param("id") int saleProductId);

     @Query(value = "SELECT d FROM SalePay d WHERE recordStatus = 'A' AND cusId = :id  ORDER BY salePayId DESC")
     List<SalePay> findByIdCus(@Param("id") int cusId);
}