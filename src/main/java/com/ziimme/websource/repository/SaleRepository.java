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

    @Query(value = "SELECT d FROM Sale d WHERE record_status = 'A' AND sale_id = :id ")
    List<Sale> findByIdSale(@Param("id") int sale_id);

    @Query(value = "SELECT d FROM Sale d WHERE record_status = 'A' AND sale_cus_id = :id ")
    List<Sale> findByIdCus(@Param("id") int sale_cus_id);

}
