package com.ziimme.websource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.SaleAll;

public interface SaleAllRepository extends JpaRepository<SaleAll, Integer> {
     @Override
     @Query(value = "SELECT w FROM SaleAll w")
     List<SaleAll> findAll();

     @Query(value = "SELECT w FROM SaleAll w WHERE cusId = :id ")
     List<SaleAll> findByIdSaleAll(@Param("id") int cusId);
}