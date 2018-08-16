package com.rent.boot;

import com.rent.model.dto.CarDto;
import com.rent.model.entity.Car;
import com.rent.model.repository.CarRepository;
import com.rent.serviceapi.CarService;
import com.rent.serviceapiimpl.CarServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {
    public CarRepository carRepository;

    @Autowired
    private CarServiceImpl carService;

    private CarServiceImpl carServiceImpl = Mockito.mock(CarServiceImpl.class);

    @Mock
    private Car car;

    private Long id;




    @Test
    public void testIfCarAdded(){
        CarDto inputCarDto = new CarDto();
        inputCarDto.setRegistrationNumber("BH-21-ABC");
        inputCarDto.setCarPrice(3200);
        inputCarDto.setCombustibleCar("Diesel");
        inputCarDto.setMarkCar("Audi");
        inputCarDto.setTransmissionCar("Manual");
        inputCarDto.setUsed("Yes");

        final CarDto dbCarDto = carService.addCarDTO(inputCarDto);

        Assert.assertEquals(inputCarDto.getMarkCar(), dbCarDto.getMarkCar());
        Assert.assertEquals(inputCarDto.getRegistrationNumber(), dbCarDto.getRegistrationNumber());
        Assert.assertEquals(inputCarDto.getCombustibleCar(), dbCarDto.getCombustibleCar());
        Assert.assertEquals(inputCarDto.getCarPrice(), dbCarDto.getCarPrice(),0.00001);
        Assert.assertEquals(inputCarDto.getTransmissionCar(), dbCarDto.getTransmissionCar());
        Assert.assertEquals(inputCarDto.getUsed(),dbCarDto.getUsed());
    }


    @Test
    public void ifFindTheCar(){
    when(carRepository.findById(id).equals(id));
    carService.findById(id);
    Assert.assertEquals(5,;
    }
}
