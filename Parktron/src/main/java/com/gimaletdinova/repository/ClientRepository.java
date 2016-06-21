package com.gimaletdinova.repository;

import com.gimaletdinova.entity.Car;
import com.gimaletdinova.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}