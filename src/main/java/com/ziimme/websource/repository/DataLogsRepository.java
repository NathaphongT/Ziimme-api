package com.ziimme.websource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ziimme.websource.models.DataLogs;

import java.util.List;

public interface DataLogsRepository extends JpaRepository<DataLogs, Integer>, JpaSpecificationExecutor<DataLogs> {
    @Query(value = "SELECT d FROM DataLogs d WHERE recordStatus = 'A' ORDER BY logId")
    List<DataLogs> findAll();
    // Page<Logs> findAll(Specification<DataLogs> specification, Pageable pageable);
}
