package com.rent.boot;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.rent.model.dto.LocationDto;
import com.rent.model.dto.RentDto;
import com.rent.model.dto.UserDto;
import com.rent.model.entity.Location;
import com.rent.model.entity.Rent;
import com.rent.model.entity.User;
import com.rent.restapi.Location.LocationController;
import com.rent.restapi.Rent.RentController;
import com.rent.restapi.User.UserController;
import com.rent.serviceapi.LocationService;
import com.rent.serviceapi.RentService;
import com.rent.serviceapi.UserService;
import com.rent.serviceapiimpl.LocationServiceImpl;
import com.rent.serviceapiimpl.RentServiceImpl;
import com.rent.serviceapiimpl.UserServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RentServiceTest {

    @Autowired
    private RentService rentService;

    @Mock
    private RentController rentController;

    @Mock
    private RentServiceImpl rentServiceImpl;

   @Test
    public void ifRentAdded(){
       RentDto rentDto = new RentDto();

       String startDate = "2018-08-21";
       String endDate = "2018-09-22";
       Date date1 = Date.valueOf(startDate);
       Date date2 = Date.valueOf(endDate);
       rentDto.setUserId(23);
       rentDto.setPrice(233);
       rentDto.setCarId(2);
       rentDto.setStartDate(date1);
       rentDto.setEndDate(date2);

       final RentDto dbRent = rentService.addRent(rentDto);

       Assert.assertEquals(rentDto.getCarId(),dbRent.getCarId());
       Assert.assertEquals(rentDto.getUserId(),dbRent.getUserId());
       Assert.assertEquals(rentDto.getStartDate(),dbRent.getStartDate());
       Assert.assertEquals(rentDto.getEndDate(),dbRent.getEndDate());
       Assert.assertEquals(rentDto.getPrice(),dbRent.getPrice(),.001);
    }

    @Test
    public void ifRentFind(){
        RentDto rentDto = new RentDto();

        String startDate = "2018-08-21";
        String endDate = "2018-09-22";
        Date date1 = Date.valueOf(startDate);
        Date date2 = Date.valueOf(endDate);
        rentDto.setUserId(23);
        rentDto.setPrice(233);
        rentDto.setCarId(2);
        rentDto.setStartDate(date1);
        rentDto.setEndDate(date2);

        final RentDto dbRent = rentService.addRent(rentDto);

        Assert.assertNotNull(rentService.findRent(dbRent.getId()));

    }

    @Test
    public void ifEditRent(){
        RentDto rentDto = new RentDto();

        String startDate1 = "2018-08-21";
        String endDate1 = "2018-09-22";
        Date date1 = Date.valueOf(startDate1);
        Date date2 = Date.valueOf(endDate1);
        rentDto.setUserId(23);
        rentDto.setPrice(233);
        rentDto.setCarId(2);
        rentDto.setStartDate(date1);
        rentDto.setEndDate(date2);

        final RentDto dbRent = rentService.addRent(rentDto);

        String startDate2 = "2018-10-21";
        String endDate2 = "2018-11-22";
        Date date3 = Date.valueOf(startDate2);
        Date date4 = Date.valueOf(endDate2);
        rentDto.setUserId(23);
        rentDto.setPrice(23234);
        rentDto.setCarId(7889);
        rentDto.setStartDate(date3);
        rentDto.setEndDate(date4);

        final RentDto dbRent2 = rentService.editRent(dbRent, dbRent.getId());

        Assert.assertEquals(dbRent.getUserId(),dbRent2.getUserId());
        Assert.assertEquals(dbRent.getStartDate(),dbRent2.getStartDate());
        Assert.assertEquals(dbRent.getEndDate(),dbRent2.getEndDate());
        Assert.assertEquals(dbRent.getPrice(),dbRent2.getPrice(),.001);
        Assert.assertEquals(dbRent.getCarId(),dbRent2.getCarId());
    }

    @Test
    public void ifFindAllRent(){
        List<RentDto> rentDtos = new ArrayList<>();
        when(rentServiceImpl.getAllRentDto()).thenReturn(rentDtos);
        List<RentDto> response = rentController.getAllRents();
        List<RentDto> expect = rentDtos;

        Assert.assertEquals(expect,response);
    }

    @Test
    public void ifDeleteRent(){
        RentDto rentDto = new RentDto();

        String startDate1 = "2018-08-21";
        String endDate1 = "2018-09-22";
        Date date1 = Date.valueOf(startDate1);
        Date date2 = Date.valueOf(endDate1);
        rentDto.setUserId(23);
        rentDto.setPrice(233);
        rentDto.setCarId(2);
        rentDto.setStartDate(date1);
        rentDto.setEndDate(date2);

        final RentDto dbRent = rentService.addRent(rentDto);

        rentService.deleteRent(dbRent.getId());

        Assert.assertNull(rentService.findRent(dbRent.getId()));
    }
}
