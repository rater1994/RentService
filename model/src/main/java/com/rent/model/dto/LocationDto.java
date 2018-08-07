package com.rent.model.dto;

import java.util.Objects;

public class LocationDto {

    private String Country;
    private String City;
    private String streetName;
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

    public int hashCode(){
        return Objects.hash(Country,City,streetName,number);
    }
}
