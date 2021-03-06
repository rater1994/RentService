package com.rent.serviceapi;

import com.rent.model.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public interface UserService  {

    List<UserDto> getAllUsers();
    UserDto addUser(@RequestBody UserDto userDto);
    UserDto editUser(@RequestBody UserDto userDto, @PathVariable Integer id);
    UserDto findUser(@PathVariable Integer id);
    UserDto login(@RequestBody UserDto userDto);
    void deleteUser(@PathVariable Integer id) throws RuntimeException;
}
