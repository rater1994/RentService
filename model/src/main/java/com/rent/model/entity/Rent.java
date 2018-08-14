package com.rent.model.entity;

import com.rent.model.dto.RentDto;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "UserId")
    private Integer userId;

    @Column(name = "CarId")
    private Integer carId;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
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

    public RentDto toRentDto(){
        RentDto rentDto = new RentDto();

        rentDto.setUserId(this.userId);
        rentDto.setCarId(this.carId);
        rentDto.setStartDate(this.startDate);
        rentDto.setEndDate(this.endDate);
        rentDto.setPrice(this.price);
        rentDto.setId(this.id);
        return rentDto;
    }

    public Rent update(RentDto dto){
        this.userId = dto.getUserId();
        this.carId = dto.getCarId();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
        this.price = dto.getPrice();
        this.id = dto.getId();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
