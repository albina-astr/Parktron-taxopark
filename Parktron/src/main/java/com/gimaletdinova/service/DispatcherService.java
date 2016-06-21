package com.gimaletdinova.service;

import com.gimaletdinova.entity.Dispatcher;

import java.util.List;

public interface DispatcherService {
    Dispatcher addDispatcher(Dispatcher dispatcher);
    void delete(Integer id);
    Dispatcher getByFio(String fio);
    Dispatcher editDispatcher(Dispatcher dispatcher);
    List<Dispatcher> getAll();
}
