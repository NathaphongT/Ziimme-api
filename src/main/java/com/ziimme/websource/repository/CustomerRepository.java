package com.ziimme.websource.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ziimme.websource.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
     @Query(value = "SELECT fc FROM Course fc WHERE recordStatus = 'A' ORDER BY courseId")
    List<Customer> findAll();
    Page<Customer> findAll(Specification<Customer> specification, Pageable pageable);
}
