package com.gimaletdinova.service.impl;

import com.gimaletdinova.entity.Car;
import com.gimaletdinova.repository.CarRepository;
import com.gimaletdinova.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        Car savedCar = carRepository.saveAndFlush(car);
        return savedCar;
    }

    @Override
    public void delete(String stateNumber_id) {
        carRepository.delete(stateNumber_id);
    }

    @Override
    public List<Car> getByMake(String make) {
        return carRepository.findByMake(make);
    }

    @Override
    public List<Car> getByComfortLevel(Integer comfortLevel) {
        return carRepository.findByComfortLevel(comfortLevel);
    }

    @Override
    public Car editCar(Car car) {
        return carRepository.saveAndFlush(car);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }
}
