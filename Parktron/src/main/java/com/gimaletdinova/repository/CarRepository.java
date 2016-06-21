package com.gimaletdinova.repository;

import com.gimaletdinova.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {
    @Query("SELECT c FROM Car c WHERE c.make = :make")
    List<Car> findByMake(@Param("make")String make);

    @Query("SELECT c FROM Car c WHERE c.comfortLevel = :comfortLevel")
    List<Car> findByComfortLevel(@Param("comfortLevel")Integer comfortLevel);
}
