package com.rent.serviceapiimpl;

import com.rent.model.dto.LocationDto;
import com.rent.model.dto.UserDto;
import com.rent.model.entity.User;
import com.rent.model.repository.UserRepository;
import com.rent.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.transform.OutputKeys;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> list = new ArrayList<>();

        userRepository.findAll().forEach(user -> {
            list.add(user.toUserDto());
        });
        return list;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = new User();
        user.update(userDto);
        return userRepository.save(user).toUserDto();
    }

    @Override
    public UserDto editUser(UserDto userDto, Long id) {
        if (userRepository.findById(id).isPresent()) {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            return userRepository.save(user).toUserDto();
        }
        return null;
    }

    @Override
    public UserDto findUser(Long id) {
        User user = userRepository.findById(id).get();
        return  user.toUserDto();
    }

    @Override
    public UserDto login(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername());
        if (user != null) {
            if (user.getPassword().equals(userDto.getPassword())) {
                System.out.println("Test");
            } else {
                System.out.println("Test2");
            }
        }
        System.out.println("Problem");
    return null;
}


    @Override
    public void deleteUser(Long id) throws RuntimeException {
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("cannot delete user! " + id);
        }
    }
}
