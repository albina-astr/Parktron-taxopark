package com.gimaletdinova.service;

import com.gimaletdinova.entity.Driver;

import java.util.List;

public interface DriverService {
    Driver addDriver(Driver driver);
    void delete(Integer id);
    Driver getByFio(String fio);
    Driver editDriver(Driver driver);
    List<Driver> getAll();
}
