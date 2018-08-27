package com.rent.restapiimpl;

import com.rent.model.dto.UserDto;
import com.rent.model.repository.UserRepository;
import com.rent.restapi.User.UserController;
import com.rent.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;

    public UserControllerImpl(UserService userService, UserRepository userRepository) {
    this.userService = userService;
    this.userRepository= userRepository;
    }


    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public ResponseEntity addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.addUser(userDto));
    }


    //Get user from list wiht id
    @Override
    public UserDto getUser(@PathVariable Integer id) {
        return userService.findUser(id);
    }

    //Update user (change user or pw)
    @Override
    public ResponseEntity updateUser(@RequestBody UserDto userDto,@PathVariable Integer id) {
        if(userRepository.findById(id).isPresent()) {
            userService.editUser(userDto, id);
            return new ResponseEntity<>("User update!", HttpStatus.OK);
        }
        return new ResponseEntity<>("The user invald", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        try {
            userService.deleteUser(id);
          //  return new ResponseEntity("User deleted", HttpStatus.OK);
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Successfully deleted!");
    }

  /*  @Override
    public ResponseEntity login(UserDto userDto) {
        userService.login(userDto);
        return new ResponseEntity<>("just some test",HttpStatus.OK);
    }*/
}
