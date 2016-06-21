package com.gimaletdinova.service.impl;

import com.gimaletdinova.entity.Dispatcher;
import com.gimaletdinova.repository.DispatcherRepository;
import com.gimaletdinova.service.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatcherServiceImpl implements DispatcherService {
    @Autowired
    private DispatcherRepository dispatcherRepository;

    @Override
    public Dispatcher addDispatcher(Dispatcher dispatcher) {
        return dispatcherRepository.saveAndFlush(dispatcher);
    }

    @Override
    public void delete(Integer id) {
        dispatcherRepository.delete(id);
    }

    @Override
    public Dispatcher getByFio(String fio) {
        return dispatcherRepository.findByFio(fio);
    }

    @Override
    public Dispatcher editDispatcher(Dispatcher dispatcher) {
        return dispatcherRepository.saveAndFlush(dispatcher);
    }

    @Override
    public List<Dispatcher> getAll() {
        return dispatcherRepository.findAll();
    }
}
