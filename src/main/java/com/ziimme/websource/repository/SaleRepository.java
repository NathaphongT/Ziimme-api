package com.ziimme.websource.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer>, JpaSpecificationExecutor<Sale> {

    @Query(value = "SELECT u FROM Sale u WHERE record_status = 'A' ORDER BY sale_id")
    List<Sale> findAll();

    @Query(value = "SELECT d FROM Sale d WHERE record_status = 'A' AND sale_id = :id ORDER BY created_time desc")
    List<Sale> findByIdSale(@Param("id") int sale_id);

    @Query(value = "SELECT d FROM Sale d WHERE record_status = 'A' AND sale_cus_id = :id ")
    List<Sale> findByIdCus(@Param("id") int sale_cus_id);

    @Query(value = "SELECT d FROM Sale d WHERE record_status = 'A' AND sale_consultant_1 = :id ")
    List<Sale> findByIdConsult(@Param("id") int sale_consultant_1);

     @Query(value = "SELECT w FROM Sale w WHERE recordStatus = 'A' AND sale_consultant = ?1")
    Optional<Sale> findBysale_consultant(String sale_consultant);

}
