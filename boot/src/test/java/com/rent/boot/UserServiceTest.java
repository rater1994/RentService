package com.rent.boot;


import com.rent.model.dto.UserDto;
import com.rent.model.entity.User;
import com.rent.restapi.User.UserController;
import com.rent.serviceapi.UserService;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;


    //@InjectMocks
    @Mock
    private UserController userController;

    @Mock
    private UserServiceImpl userServiceImpl;

    @Test
    public void testIfUserAdded(){
        UserDto userDto = new UserDto();
        userDto.setUsername("user1");
        userDto.setPassword("P@ssw0rd");

        final UserDto dbUser = userService.addUser(userDto);
        Assert.assertEquals(userDto.getUsername(),dbUser.getUsername());
        Assert.assertEquals(userDto.getPassword(),dbUser.getPassword());
    }

    @Test
    public void testIfUserFindById(){
        UserDto userDto = new UserDto();
        userDto.setUsername("user1");
        userDto.setPassword("P@ssw0rd");

        final UserDto dbUser = userService.addUser(userDto);

        Assert.assertNotNull(userService.findUser(dbUser.getId()));
    }

    @Test
    public void testIfEditUser(){
        UserDto userDto = new UserDto();
        userDto.setUsername("User1");
        userDto.setPassword("P@ssw0rd");

        final UserDto dbUser = userService.addUser(userDto);


        userDto.setUsername("User2");
        userDto.setPassword("P@ssw");

        final UserDto dbUser2 = userService.editUser(dbUser,dbUser.getId());

        Assert.assertEquals(dbUser.getUsername(),dbUser2.getUsername());
        Assert.assertEquals(dbUser.getPassword(),dbUser2.getPassword());

    }

    @Test
    public void ifFindAllUser(){
        List <UserDto> userDtos = new ArrayList<>();
        when(userServiceImpl.getAllUsers()).thenReturn(userDtos);
        List<UserDto> response = userController.getAllUsers();
        List<UserDto> expectet = userDtos;

        Assert.assertEquals(expectet,response);
    }

    @Test
    public void ifDeleteUser(){
        UserDto userDto = new UserDto();
        userDto.setUsername("User2");
        userDto.setPassword("P@ssw");

        final UserDto dbUser = userService.addUser(userDto);

        userService.deleteUser(dbUser.getId());

        Assert.assertNull(userService.findUser(dbUser.getId()));

    }

    @Test
    public void ifUserLogin(){
        UserDto userDto = new UserDto();

        userDto.setUsername("user1");
        userDto.setPassword("P@ssw0rd");

        final UserDto  dbUser = userService.addUser(userDto);

        Assert.assertSame(userDto.getPassword(),dbUser.getPassword());
    }

}
