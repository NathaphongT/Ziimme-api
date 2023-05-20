package com.ziimme.websource.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziimme.websource.models.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

    @Query(value = "SELECT u FROM Users u WHERE recordStatus = 'A' ORDER BY userId")
    List<Users> findAll();

    @Query(value = "SELECT u FROM Users u WHERE username = :username AND recordStatus = 'A'")
    Optional<Users> findByUserNameAndPassword(@Param("username") String username);

    @Query(value = "SELECT u FROM Users u WHERE username = :username AND recordStatus = 'A'")
    Optional<Users> findUsername(@Param("username") String username);
}
