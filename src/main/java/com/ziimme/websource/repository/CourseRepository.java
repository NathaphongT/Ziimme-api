package com.ziimme.websource.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {

    @Query(value = "SELECT u FROM Course u WHERE recordStatus = 'A' ORDER BY course_id")
    List<Course> findAll();

    @Query(value = "SELECT u FROM Course u WHERE course_name = :course_name AND recordStatus = 'A'")
    Optional<Course> findBycourse_name(@Param("course_name") String course_name);

    @Query(value = "SELECT u FROM Course u WHERE course_name = :course_name AND recordStatus = 'A'")
    Optional<Course> findcourse_name(@Param("course_name") String course_name);

}
