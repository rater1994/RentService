package com.rent.restapi.User;

import com.rent.model.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public interface UserController {

    @GetMapping("/list")
    List<UserDto> getAllUsers();
}
