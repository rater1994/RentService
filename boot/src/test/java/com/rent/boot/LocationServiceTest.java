package com.rent.boot;

import com.rent.model.dto.LocationDto;
import com.rent.model.dto.UserDto;
import com.rent.model.entity.Location;
import com.rent.model.entity.User;
import com.rent.restapi.Location.LocationController;
import com.rent.restapi.User.UserController;
import com.rent.serviceapi.LocationService;
import com.rent.serviceapi.UserService;
import com.rent.serviceapiimpl.LocationServiceImpl;
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
public class LocationServiceTest {

    @Autowired
    private LocationService locationService;

    @Mock
    private LocationController locationController;

    @Mock
    private LocationServiceImpl locationServiceImpl;


    @Test
    public void testIfLocationAdded(){
        LocationDto locationDto = new LocationDto();
        locationDto.setCountry("Ro");
        locationDto.setCity("Or");
        locationDto.setStreetName("Address");
        locationDto.setNumber("23");

        final LocationDto dbLocation = locationService.addLocation(locationDto);

        Assert.assertEquals(locationDto.getCity(),dbLocation.getCity());
        Assert.assertEquals(locationDto.getCountry(),dbLocation.getCountry());
        Assert.assertEquals(locationDto.getNumber(),dbLocation.getNumber());
        Assert.assertEquals(locationDto.getStreetName(),dbLocation.getStreetName());
    }

    @Test
    public void testIfLocationFind(){
        LocationDto locationDto = new LocationDto();
        locationDto.setCountry("Ro");
        locationDto.setCity("Or");
        locationDto.setStreetName("Address");
        locationDto.setNumber("23");

        final LocationDto dbLocation = locationService.addLocation(locationDto);

        Assert.assertNotNull(locationService.getLocation(dbLocation.getId()));

    }

    @Test
    public void testIfLocationEdit(){
        LocationDto locationDto = new LocationDto();
        locationDto.setCountry("Ro");
        locationDto.setCity("Or");
        locationDto.setStreetName("Address");
        locationDto.setNumber("23");

        final LocationDto dbLocation = locationService.addLocation(locationDto);

        locationDto.setCountry("It");
        locationDto.setCity("Or");
        locationDto.setStreetName("Address");
        locationDto.setNumber("2Q3");

        final LocationDto dbLocation2 = locationService.editLocation(dbLocation,dbLocation.getId());

        Assert.assertEquals(dbLocation.getStreetName(),dbLocation2.getStreetName());
        Assert.assertEquals(dbLocation.getNumber(),dbLocation2.getNumber());
        Assert.assertEquals(dbLocation.getCountry(),dbLocation2.getCountry());
        Assert.assertEquals(dbLocation.getCity(),dbLocation2.getCity());

    }

    @Test
    public void ifFindAllLocation(){
        List<LocationDto> locationDtos = new ArrayList<>();
        when(locationController.getAllLocation()).thenReturn(locationDtos);
        List<LocationDto> response = locationController.getAllLocation();
        List<LocationDto> expected = locationDtos;

        Assert.assertEquals(expected,response);
    }


    @Test
    public void ifDeletedLocation(){
        LocationDto locationDto = new LocationDto();
        locationDto.setCountry("It");
        locationDto.setCity("Or");
        locationDto.setStreetName("Address");
        locationDto.setNumber("2Q3");

        final LocationDto dbLocation = locationService.addLocation(locationDto);

        locationService.deleteLocationDto(dbLocation.getId());

        Assert.assertNull(locationService.getLocation(dbLocation.getId()));
    }
}
