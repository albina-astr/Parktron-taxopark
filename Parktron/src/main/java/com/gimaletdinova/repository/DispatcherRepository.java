package com.gimaletdinova.repository;

import com.gimaletdinova.entity.Car;
import com.gimaletdinova.entity.Dispatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DispatcherRepository extends JpaRepository<Dispatcher, Integer> {
    @Query("SELECT c FROM Dispatcher c WHERE c.fio = :fio")
    Dispatcher findByFio(@Param("fio")String fio);
}
