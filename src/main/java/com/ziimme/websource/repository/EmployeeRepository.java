package com.ziimme.websource.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    @Query(value = "SELECT u FROM Employee u WHERE recordStatus = 'A' ORDER BY emp_id")
    List<Employee> findAll();

    @Query(value = "SELECT u FROM Employee u WHERE emp_fullname = :emp_fullname AND recordStatus = 'A'")
    Optional<Employee> findByemp_fullname(@Param("emp_fullname") String emp_fullname);

    @Query(value = "SELECT u FROM Employee u WHERE emp_fullname = :emp_fullname AND recordStatus = 'A'")
    Optional<Employee> findemp_fullname(@Param("emp_fullname") String emp_fullname);
}
