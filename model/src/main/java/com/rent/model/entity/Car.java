package com.rent.model.entity;

import javax.persistence.*;
import com.rent.model.dto.CarDto;

@Entity //
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "Registration number")
    private String registrationNumber;

    @Column(name = "Combustible car")
    private String combustibleCar;

    @Column(name = "Car price")
    private double carPrice;

    @Column(name ="Transmission car")
    private String transmissionCar;

    @Column(name ="Mark car")
    private String markCar;

    @Column(name = "Used")
    private boolean used;


    public String getMarkCark() {
        return markCar;
    }

    public void setMarkCark(String markCar) {
        this.markCar = markCar;
    }

    public String getTransmissionCar() {
        return transmissionCar;
    }

    public void setTransmissionCar(String transmissionCar) {
        this.transmissionCar = transmissionCar;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public String getCombustibleCar() {
        return combustibleCar;
    }

    public void setCombustibleCar(String combustibleCar) {
        this.combustibleCar = combustibleCar;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public CarDto toDto(){
        CarDto carDto = new CarDto();

        carDto.setCarPrice(this.carPrice);
        carDto.setCombustibleCar(this.combustibleCar);
        carDto.setMarkCar(this.markCar);
        carDto.setRegistrationNumber(this.registrationNumber);
        carDto.setTransmissionCar(this.transmissionCar);
        carDto.setUsed(this.used);
        return carDto;
    }

    public Car update(CarDto dto){
        this.carPrice = dto.getCarPrice();
        this.combustibleCar = dto.getCombustibleCar();
        this.markCar = dto.getMarkCar();
        this.registrationNumber = dto.getRegistrationNumber();
        this.transmissionCar = dto.getTransmissionCar();
        this.used = dto.isUsed();
        return this;
    }



}