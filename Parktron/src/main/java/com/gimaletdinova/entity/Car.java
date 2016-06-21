package com.gimaletdinova.entity;

import javax.persistence.*;

@Entity
@Table(name = "CARS")
public class Car {
    @Id
    @Column(name = "stateNumber", length = 50)
    private String stateNumber;
    @Column(name = "isOwn", length = 6, nullable = false)
    private int isOwn;
    @Column(name = "make", length = 20, nullable = false)
    private String make;
    @Column(name = "color", length = 20, nullable = false)
    private String color;
    @Column(name = "comfortLevel", length = 6, nullable = false)
    private int comfortLevel;

    public Car() {
    }

    public Car(String stateNumber, int isOwn, String make, String color, int comfortLevel) {
        this.stateNumber = stateNumber;
        this.isOwn = isOwn;
        this.make = make;
        this.color = color;
        this.comfortLevel = comfortLevel;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public int getIsOwn() {
        return isOwn;
    }

    public void setIsOwn(int isOwn) {
        this.isOwn = isOwn;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(int comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    @Override
    public String toString() {
        return "Car:\nStateNumber: " + stateNumber + "\nIs own: " + isOwn + "\nMake: " + make +
                "\nColor: " + color + "\nComfortLevel: " + comfortLevel;
    }
}
