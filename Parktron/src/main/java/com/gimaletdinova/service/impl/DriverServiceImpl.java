package com.gimaletdinova.service.impl;

import com.gimaletdinova.entity.Driver;
import com.gimaletdinova.repository.DriverRepository;
import com.gimaletdinova.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public void delete(Integer id) {
        driverRepository.delete(id);
    }

    @Override
    public Driver getByFio(String fio) {
        return driverRepository.findByFio(fio);
    }

    @Override
    public Driver editDriver(Driver driver) {
        return driverRepository.saveAndFlush(driver);
    }

    @Override
    public List<Driver> getAll() {
        return driverRepository.findAll();
    }
}
