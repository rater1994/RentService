package com.rent.model.entity;

import com.rent.model.dto.LocationDto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Country")
    private String Country;

    @Column(name = "City")
    private String City;

    @Column(name = "Street name")
    private String streetName;

    @Column(name = "Number")
    private String number;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocationDto locationDto(){
        LocationDto locationDto = new LocationDto();
        locationDto.setCountry(this.Country);
        locationDto.setCity(this.City);
        locationDto.setStreetName(this.streetName);
        locationDto.setNumber(this.number);
        return locationDto;
    }

    public Location update(LocationDto dto){
        this.Country = dto.getCountry();
        this.City = dto.getCity();
        this.streetName = dto.getStreetName();
        this.number = dto.getNumber();
        return  this;
    }

}
