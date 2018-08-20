package com.rent.boot;

import com.rent.model.dto.CarDto;
import com.rent.model.entity.Car;
import com.rent.model.repository.CarRepository;
import com.rent.restapi.Car.CarController;
import com.rent.restapiimpl.CarControllerImpl;
import com.rent.serviceapi.CarService;
import com.rent.serviceapiimpl.CarServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Id;
import javax.smartcardio.Card;
import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {
    public CarRepository carRepository;

    @InjectMocks
    private CarControllerImpl carControllerImpl;


   @Autowired
    //@Mock
    private CarServiceImpl carService;


   @Mock
   private CarServiceImpl carServiceMock;


    @Mock
    private Car car;

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
    public void testIfCandFindByIdCar(){
        CarDto inputCarDto = new CarDto();
        Long id = 2L;
        inputCarDto.setId(id);
        inputCarDto.setRegistrationNumber("BH-21-ABC");
        inputCarDto.setCarPrice(3200);
        inputCarDto.setCombustibleCar("Diesel");
        inputCarDto.setMarkCar("Audi");
        inputCarDto.setTransmissionCar("Manual");
        inputCarDto.setUsed("Yes");

        final CarDto dbCar =  carService.addCarDTO(inputCarDto);
        Assert.assertNotNull(carService.findById(dbCar.getId()));

    }


    @Test
    public void testIfEditCar(){
        CarDto carDto = new CarDto();
        carDto.setRegistrationNumber("BH-21-ABC");
        carDto.setCarPrice(3200);
        carDto.setCombustibleCar("Diesel");
        carDto.setMarkCar("Audi");
        carDto.setTransmissionCar("Manual");
        carDto.setUsed("Yes");

        final CarDto dbCar = carService.addCarDTO(carDto);

        dbCar.setRegistrationNumber("BH-21-DBC");
        dbCar.setCarPrice(6200);
        dbCar.setCombustibleCar("Benzin");
        dbCar.setMarkCar("Dacia");
        dbCar.setTransmissionCar("Manual");
        dbCar.setUsed("NO");

        final CarDto dbCar2 = carService.editCarDTO(dbCar, dbCar.getId());

        Assert.assertEquals(dbCar.getId(),dbCar2.getId());
        Assert.assertEquals(dbCar.getRegistrationNumber(),dbCar2.getRegistrationNumber());
        Assert.assertEquals(dbCar.getCarPrice(),dbCar2.getCarPrice(),.01);
        Assert.assertEquals(dbCar.getCombustibleCar(),dbCar2.getCombustibleCar());
        Assert.assertEquals(dbCar.getMarkCar(),dbCar2.getMarkCar());
        Assert.assertEquals(dbCar.getTransmissionCar(),dbCar2.getTransmissionCar());
        Assert.assertEquals(dbCar.getUsed(),dbCar2.getUsed());
    }


    @Test
    public void testIfFindAllCars(){

        List<CarDto> carDtos = new ArrayList<>();

        when(carServiceMock.getAllCarsDTO()).thenReturn(carDtos);
        List<CarDto> response = carControllerImpl.getAllCars();
        List<CarDto> expected = carDtos;

        Assert.assertEquals(expected,response);

    }

   @Test
    public void testIfDeleteCar(){

        CarDto inputCarDto = new CarDto();

        inputCarDto.setRegistrationNumber("BH-21-ABC");
        inputCarDto.setCarPrice(3200);
        inputCarDto.setCombustibleCar("Diesel");
        inputCarDto.setMarkCar("Audi");
        inputCarDto.setTransmissionCar("Manual");
        inputCarDto.setUsed("Yes");
        final CarDto dbCarDto = carService.addCarDTO(inputCarDto);
        carService.deleteCarDTO(dbCarDto.getId());
        Assert.assertNull(carService.findById(dbCarDto.getId()));
    }



}
