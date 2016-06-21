package com.gimaletdinova.repository;

import com.gimaletdinova.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    @Query("SELECT c FROM Driver c WHERE c.fio = :fio")
    Driver findByFio(@Param("fio")String fio);
}
