package com.gimaletdinova.service;

import com.gimaletdinova.entity.Client;

import java.util.List;

public interface ClientService {
    Client addClient(Client client);
    void delete(Integer id);
    Client editClient(Client client);
    List<Client> getAll();
}
