package com.ziimme.websource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.PostCode;

public interface PostCodeRepository extends JpaRepository<PostCode, Integer>, JpaSpecificationExecutor<PostCode> {

    @Query(value = "SELECT d FROM PostCode d WHERE record_status = 'A' AND sub_districts_id = :id ")
    List<PostCode> findById(@Param("id") int sub_districts_id);

}
