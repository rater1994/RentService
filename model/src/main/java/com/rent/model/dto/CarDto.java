package com.rent.model.dto;

import java.util.Objects;

public class CarDto {
    private String registrationNumber;
    private String combustibleCar;
    private double carPrice;
    private String transmissionCar;
    private String markCar;
    private boolean used;

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

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }


}
