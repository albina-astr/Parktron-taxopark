package com.gimaletdinova.service;

import com.gimaletdinova.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
    Order addOrder(Order order);
    void delete(Integer id);
    Order editOrder(Order order);
    List<Order> getAll();

    List<Order> getByStatus(String status);
    List<Order> getByClient(Client client);
    List<Order> getByDeparturePoint(String departurePoint);
    List<Order> getByArrivalPoint(String arrivalPoint);
    List<Order> getByDepartureTime(Timestamp departureTime);
    List<Order> getByOrderTime(Timestamp orderTime);
    List<Order> getByDispatcher(Dispatcher dispatcher);
    List<Order> getByOrderProperties(String orderProperties);
    //TODO:: query for newCompanyId
    List<Order> getByEstimatedCost(double estimatedCost);
    List<Order> getByArrivalTime(Timestamp arrivalTime);
    List<Order> getByOrderStartTime(Timestamp startTime);
    List<Order> getByEndTime(Timestamp endTime);
    List<Order> getByEndPoint(String endPoint);
    List<Order> getByDowntime(long downtime);
    List<Order> getByRealCost(double realCost);
    List<Order> getByRealPayment(double realPayment);
    List<Order> getByCarStateNumber(Car carStateNumber);
    List<Order> getByDriver(Driver driver);
    List<Order> getByDelayCause(String delayCause);

    List<Order> getByDepartureArrivalPoints(String departurePoint, String arrivalPoint);
    Order getByDepartureArrivalPointsClient(String departurePoint, String arrivalPoint, Client client);
}
