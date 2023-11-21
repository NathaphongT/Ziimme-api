package com.ziimme.websource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.Logs;

public interface LogsRepo extends JpaRepository<Logs, Long> {
    @Override
    @Query(value = "SELECT l FROM Logs l WHERE record_status = 'A' ORDER BY created_time desc")
    List<Logs> findAll();

    @Query(value = "SELECT l FROM Logs l  WHERE record_status = 'A' and created_by = :username ORDER BY created_time desc")
    List<Logs> findByUsername(@Param("username") String username);
}
