package com.rent.boot;
import com.rent.model.dto.LocationDto;
import com.rent.model.dto.RentDto;
import com.rent.model.dto.UserDto;
import com.rent.model.entity.Location;
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
import java.util.ArrayList;
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


  /*  @Test
    public void ifRentAdded(){
        RentDto rentDto = new RentDto();

        rentDto.setUserId(23);
        rentDto.setPrice(2333);
       rentDto.setStartDate('2018-08-20');
    }*/
}
