package com.rent.model.dto;

import java.util.Objects;

public class CarDto {
    private String registrationNumber;
    private String combustibleCar;
    private double carPrice;
    private String transmissionCar;
    private String markCar;
    private String used;
    private Long id;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCombustibleCar() {
        return combustibleCar;
    }

    public void setCombustibleCar(String combustibleCar) {
        this.combustibleCar = combustibleCar;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public String getTransmissionCar() {
        return transmissionCar;
    }

    public void setTransmissionCar(String transmissionCar) {
        this.transmissionCar = transmissionCar;
    }

    public String getMarkCar() {
        return markCar;
    }

    public void setMarkCar(String markCar) {
        this.markCar = markCar;
    }


    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
