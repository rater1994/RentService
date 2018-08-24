package com.rent.model.entity;

import javax.persistence.*;

import com.rent.model.dto.CarDto;

@Entity
public class Car {
    @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "RegistrationNumber")
    private String registrationNumber;

    @Column(name = "CombustibleCar")
    private String combustibleCar;

    @Column(name = "CarPrice")
    private Double carPrice;

    @Column(name ="TransmissionCar")
    private String transmissionCar;

    @Column(name ="MarkCar")
    private String markCar;

//If the care is used  to know in timess
    @Column(name = "Used")
    private String used;

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

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
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

    public CarDto toCarDto(){
        CarDto carDto = new CarDto();

        carDto.setCarPrice(this.carPrice);
        carDto.setCombustibleCar(this.combustibleCar);
        carDto.setMarkCar(this.markCar);
        carDto.setRegistrationNumber(this.registrationNumber);
        carDto.setTransmissionCar(this.transmissionCar);
        carDto.setUsed(this.used);
        carDto.setId(this.id);
        return carDto;
    }

    public void update(CarDto dto){

        this.carPrice = dto.getCarPrice();
        this.combustibleCar = dto.getCombustibleCar();
        this.markCar = dto.getMarkCar();
        this.registrationNumber = dto.getRegistrationNumber();
        this.transmissionCar = dto.getTransmissionCar();
        this.id = dto.getId();
        this.used = dto.getUsed();

    }



}