package com.gimaletdinova.repository;

import com.gimaletdinova.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT c FROM Order c WHERE c.status = :status")
    List<Order> findByStatus(@Param("status")String status);

    @Query("SELECT c FROM Order c WHERE c.client = :client")
    List<Order> findByClient(@Param("client")Client client);

    @Query("SELECT c FROM Order c WHERE c.departurePoint = :departurePoint")
    List<Order> findByDeparturePoint(@Param("departurePoint")String departurePoint);

    @Query("SELECT c FROM Order c WHERE c.arrivalPoint = :arrivalPoint")
    List<Order> findByArrivalPoint(@Param("arrivalPoint")String arrivalPoint);

    @Query("SELECT c FROM Order c WHERE c.departureTime = :departureTime")
    List<Order> findByDepartureTime(@Param("departureTime")Timestamp departureTime);

    @Query("SELECT c FROM Order c WHERE c.orderTime = :orderTime")
    List<Order> findByOrderTime(@Param("orderTime")Timestamp orderTime);

    @Query("SELECT c FROM Order c WHERE c.dispatcher = :dispatcher")
    List<Order> findByDispatcher(@Param("dispatcher")Dispatcher dispatcher);

    @Query("SELECT c FROM Order c WHERE c.orderProperties = :orderProperties")
    List<Order> findByOrderProperties(@Param("orderProperties")String orderProperties);

    //TODO:: query for newCompanyId

    @Query("SELECT c FROM Order c WHERE c.estimatedCost = :estimatedCost")
    List<Order> findByEstimatedCost(@Param("estimatedCost")double estimatedCost);

    @Query("SELECT c FROM Order c WHERE c.arrivalTime = :arrivalTime")
    List<Order> findByArrivalTime(@Param("arrivalTime")Timestamp arrivalTime);

    @Query("SELECT c FROM Order c WHERE c.startTime = :startTime")
    List<Order> findByOrderStartTime(@Param("startTime")Timestamp startTime);

    @Query("SELECT c FROM Order c WHERE c.endTime = :endTime")
    List<Order> findByEndTime(@Param("endTime")Timestamp endTime);

    @Query("SELECT c FROM Order c WHERE c.endPoint = :endPoint")
    List<Order> findByEndPoint(@Param("endPoint")String endPoint);

    @Query("SELECT c FROM Order c WHERE c.downtime = :downtime")
    List<Order> findByDowntime(@Param("downtime")long downtime);

    @Query("SELECT c FROM Order c WHERE c.realCost = :realCost")
    List<Order> findByRealCost(@Param("realCost")double realCost);

    @Query("SELECT c FROM Order c WHERE c.realPayment = :realPayment")
    List<Order> findByRealPayment(@Param("realPayment")double realPayment);

    @Query("SELECT c FROM Order c WHERE c.carStateNumber = :carStateNumber")
    List<Order> findByCarStateNumber(@Param("carStateNumber")Car carStateNumber);

    @Query("SELECT c FROM Order c WHERE c.driver = :driver")
    List<Order> findByDriver(@Param("driver")Driver driver);

    @Query("SELECT c FROM Order c WHERE c.delayCause = :delayCause")
    List<Order> findByDelayCause(@Param("delayCause")String delayCause);

    @Query("SELECT c FROM Order c WHERE c.departurePoint = :departurePoint AND c.arrivalPoint = :arrivalPoint")
    List<Order> findByDepartureArrivalPoints(@Param("departurePoint")String departurePoint, @Param("arrivalPoint")String arrivalPoint);

    @Query("SELECT c FROM Order c WHERE c.departurePoint = :departurePoint AND c.arrivalPoint = :arrivalPoint " +
            "AND c.client = :client")
    Order findByDepartureArrivalPointsClient(@Param("departurePoint")String departurePoint,
                                             @Param("arrivalPoint")String arrivalPoint,
                                             @Param("client")Client client);
}