package com.gimaletdinova.service;

import com.gimaletdinova.entity.Car;

import java.util.List;

public interface CarService {
    Car addCar(Car car);
    void delete(String id);
    List<Car> getByMake(String make);
    List<Car> getByComfortLevel(Integer comfortLevel);
    Car editCar(Car car);
    List<Car> getAll();
}
