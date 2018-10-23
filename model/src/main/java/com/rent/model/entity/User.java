package com.rent.model.entity;
import com.rent.model.dto.UserDto;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    private String token;

    private String roles;

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public User(){

    }

    public String getRoles() {
        return roles;
    }

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.roles;
        this.id = user.getId();

    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto toUserDto(){
        UserDto userDto = new UserDto();

        userDto.setUsername(this.username);
        userDto.setPassword(this.password);
        userDto.setId(this.id);
        userDto.setRoles(this.roles);
        return userDto;
    }

    public User update( UserDto dto){
        this.username = dto.getUsername();
        this.password = dto.getPassword();
        this.roles = dto.getRoles();
        this.id = dto.getId();
        return this;
    }

}