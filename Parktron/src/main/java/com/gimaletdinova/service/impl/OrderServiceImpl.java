package com.gimaletdinova.service.impl;

import com.gimaletdinova.entity.*;
import com.gimaletdinova.repository.OrderRepository;
import com.gimaletdinova.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.delete(id);
    }

    @Override
    public Order editOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public List<Order> getByClient(Client client) {
        return orderRepository.findByClient(client);
    }

    @Override
    public List<Order> getByDeparturePoint(String departurePoint) {
        return orderRepository.findByDeparturePoint(departurePoint);
    }

    @Override
    public List<Order> getByArrivalPoint(String arrivalPoint) {
        return orderRepository.findByArrivalPoint(arrivalPoint);
    }

    @Override
    public List<Order> getByDepartureTime(Timestamp departureTime) {
        return orderRepository.findByDepartureTime(departureTime);
    }

    @Override
    public List<Order> getByOrderTime(Timestamp orderTime) {
        return orderRepository.findByOrderTime(orderTime);
    }

    @Override
    public List<Order> getByDispatcher(Dispatcher dispatcher) {
        return orderRepository.findByDispatcher(dispatcher);
    }

    @Override
    public List<Order> getByOrderProperties(String orderProperties) {
        return orderRepository.findByOrderProperties(orderProperties);
    }

    @Override
    public List<Order> getByEstimatedCost(double estimatedCost) {
        return orderRepository.findByEstimatedCost(estimatedCost);
    }

    @Override
    public List<Order> getByArrivalTime(Timestamp arrivalTime) {
        return orderRepository.findByArrivalTime(arrivalTime);
    }

    @Override
    public List<Order> getByOrderStartTime(Timestamp startTime) {
        return orderRepository.findByOrderStartTime(startTime);
    }

    @Override
    public List<Order> getByEndTime(Timestamp endTime) {
        return orderRepository.findByEndTime(endTime);
    }

    @Override
    public List<Order> getByEndPoint(String endPoint) {
        return orderRepository.findByEndPoint(endPoint);
    }

    @Override
    public List<Order> getByDowntime(long downtime) {
        return orderRepository.findByDowntime(downtime);
    }

    @Override
    public List<Order> getByRealCost(double realCost) {
        return orderRepository.findByRealCost(realCost);
    }

    @Override
    public List<Order> getByRealPayment(double realPayment) {
        return orderRepository.findByRealPayment(realPayment);
    }

    @Override
    public List<Order> getByCarStateNumber(Car carStateNumber) {
        return orderRepository.findByCarStateNumber(carStateNumber);
    }

    @Override
    public List<Order> getByDriver(Driver driver) {
        return orderRepository.findByDriver(driver);
    }

    @Override
    public List<Order> getByDelayCause(String delayCause) {
        return orderRepository.findByDelayCause(delayCause);
    }

    @Override
    public List<Order> getByDepartureArrivalPoints(String departurePoint, String arrivalPoint) {
        return orderRepository.findByDepartureArrivalPoints(departurePoint, arrivalPoint);
    }

    @Override
    public Order getByDepartureArrivalPointsClient(String departurePoint, String arrivalPoint, Client client) {
        return orderRepository.findByDepartureArrivalPointsClient(departurePoint, arrivalPoint, client);
    }
}
