package com.rent.restapiimpl;

import com.rent.model.dto.UserDto;
import com.rent.model.repository.UserRepository;
import com.rent.restapi.User.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> list = new ArrayList<>();

        userRepository.findAll().forEach(user -> {
            list.add(user.toDto());
        });
        return list;
    }
}
