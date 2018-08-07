package com.rent.model.entity;

import com.rent.model.dto.RentDto;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "User id")
    private Integer userId;

    @Column(name = "Car id")
    private Integer carId;

    @Column(name = "Start date")
    private Date startDate;

    @Column(name = "End date")
    private Date endDate;

    @Column(name = "Price")
    private double price;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RentDto toDto(){
        RentDto rentDto = new RentDto();

        rentDto.setCarId(this.carId);
        rentDto.setStartDate(this.startDate);
        rentDto.setEndDate(this.endDate);
        rentDto.setUserId(this.userId);
        rentDto.setPrice(this.price);
        return rentDto;
    }

    public Rent update(RentDto dto){
        this.carId = dto.getCarId();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
        this.userId = dto.getUserId();
        this.price = dto.getPrice();
        return this;
    }
}
