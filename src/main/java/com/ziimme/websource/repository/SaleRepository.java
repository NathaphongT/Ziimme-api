package com.ziimme.websource.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.Sale;
import com.ziimme.websource.models.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer>, JpaSpecificationExecutor<Sale> {

    @Query(value = "SELECT w FROM Sale w WHERE recordStatus = 'A' ORDER BY saleId")
    List<Sale> findAll();

    Page<Sale> findAll(Specification<Sale> specification, Pageable pageable);

    @Query(value = "SELECT d FROM Sale d WHERE record_status = 'A' AND saleId = :id ORDER BY createdTime desc")
    List<Sale> findByIdSale(@Param("id") int saleId);

    @Query(value = "SELECT d FROM Sale d WHERE record_status = 'A' AND cusId = :id ")
    List<Sale> findByIdCus(@Param("id") int cusId);

    @Query(value = "SELECT w FROM Sale w WHERE recordStatus = 'A' AND saleNumber = ?1")
    Optional<Sale> findBySaleName(String saleNumber);

}
