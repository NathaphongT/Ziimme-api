package com.ziimme.websource.repository;

import com.ziimme.websource.models.SaleEmployee;
import com.ziimme.websource.models.SaleProduct;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, Integer> {
  List<SaleProduct> findBySaleId(int saleId);
  @Transactional
  void deleteBySaleId(int saleId);
}