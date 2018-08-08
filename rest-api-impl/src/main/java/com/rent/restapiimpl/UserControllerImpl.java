package com.rent.restapiimpl;

import com.rent.model.dto.UserDto;
import com.rent.model.entity.User;
import com.rent.model.repository.UserRepository;
import com.rent.restapi.User.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
            list.add(user.toUserDto());
        });
        return list;
    }

    @Override
    public ResponseEntity addUser(@RequestBody UserDto userDto) {
        User user = new User();
        if(userDto != null){
            user.update(userDto);
            userRepository.save(user);
            return new ResponseEntity<String>("The user was added", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Invald data input", HttpStatus.BAD_REQUEST);
    }


    //Get user from list wiht id
    @Override
    public UserDto getUser(@PathVariable Long id) {
        User user = userRepository.findById(id).get();
        return user.toUserDto();
    }

    //Update user (change user or pw)
    @Override
    public ResponseEntity updateUser(@RequestBody UserDto userDto,@PathVariable Long id) {
        User user = userRepository.findById(id).get();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return new ResponseEntity<String>("User update!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);

        return new ResponseEntity("User deleted", HttpStatus.OK);
    }

    @Override
    public ResponseEntity login(@RequestBody UserDto userS) {
        User user = userRepository.findByUsername(userS.getUsername());
        if(user!=null){
        if(user.getPassword().equals(userS.getPassword())){
            return  new ResponseEntity("Login succesful", HttpStatus.OK);
        }else{
            return new ResponseEntity("Incorrect password",HttpStatus.BAD_GATEWAY);
            }
        }
        return new ResponseEntity("Username not exist!",HttpStatus.BAD_REQUEST);
    }

}
