package com.rent.restapiimpl;

import com.rent.model.dto.UserDto;
import com.rent.restapi.User.UserController;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {
    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }
}
