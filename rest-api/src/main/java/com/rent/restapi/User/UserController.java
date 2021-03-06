package com.rent.restapi.User;

import com.rent.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public interface UserController {

    @GetMapping("/list")
    List<UserDto> getAllUsers();

    @PostMapping("/add")
    ResponseEntity addUser(@RequestBody UserDto userDto);

    @GetMapping("/find/{id}")
    UserDto getUser(@PathVariable Integer id);

    @PutMapping("/edit/{id}")
    ResponseEntity updateUser(@RequestBody UserDto userDto, @PathVariable Integer id);

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteUser(@PathVariable Integer id);

  /*  @PostMapping("/login")
    ResponseEntity login(@RequestBody UserDto userDto);*/
}
