package com.gimaletdinova.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    private String status;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "client")
    private Client client;

    private String departurePoint;

    @Column(name = "arrivalPoint", nullable = false)
    private String arrivalPoint;

    private Timestamp departureTime;

    private Timestamp orderTime;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "dispatcher")
    private Dispatcher dispatcher;

    private String orderProperties;

    private double estimatedCost;

    private Integer newCompanyId;

    private Timestamp arrivalTime; // момент прибытия машины

    private Timestamp startTime; // момент посадки

    private Timestamp endTime; // момент высадки

    private String endPoint; // место высадки

    private long downtime;

    private double realCost;

    private double realPayment;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Car carStateNumber;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Driver driver;

    private String delayCause;

    public Order(Dispatcher dispatcher, Client client, String arrivalPoint) {
        this.dispatcher = dispatcher;
        this.client = client;
        this.arrivalPoint = arrivalPoint;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public String getOrderProperties() {
        return orderProperties;
    }

    public void setOrderProperties(String orderProperties) {
        this.orderProperties = orderProperties;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public Integer getNewCompanyId() {
        return newCompanyId;
    }

    public void setNewCompanyId(Integer newCompanyId) {
        this.newCompanyId = newCompanyId;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public double getDowntime() {
        return downtime;
    }

    public void setDowntime(long downtime) {
        this.downtime = downtime;
    }

    public double getRealCost() {
        return realCost;
    }

    public void setRealCost(double realCost) {
        this.realCost = realCost;
    }

    public double getRealPayment() {
        return realPayment;
    }

    public void setRealPayment(double realPayment) {
        this.realPayment = realPayment;
    }

    public Car getCarStateNumber() {
        return carStateNumber;
    }

    public void setCarStateNumber(Car carStateNumber) {
        this.carStateNumber = carStateNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getDelayCause() {
        return delayCause;
    }

    public void setDelayCause(String delayCause) {
        this.delayCause = delayCause;
    }

    @Override
    public String toString() {
        return "Order:\nId: " + id + "\nStatus: " + status + "\nClient: " + client +
                "\nDeparture point: " + departurePoint + "\nArrival point: " + arrivalPoint +
                "\nDeparture time: " + departureTime + "\nOrder Time: " + orderTime +
                "\nDispatcher: " + dispatcher + "\nOrder Properties: " + orderProperties +
                "\nEstimated cost: " + estimatedCost + "\nNew company Id: " + newCompanyId +
                "\nArrival time: " + arrivalTime + "\nStart time: " + startTime +
                "\nEnd time: " + endTime + "\nEnd point: " + endPoint + "\nDowntime: " + downtime +
                "\nReal cost: " + realCost + "\nReal payment: " + realPayment +
                "\nCar state number: " + carStateNumber + "\nDriver: " + driver + "\nDelay cause: " + delayCause;
    }
}