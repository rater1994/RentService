package com.rent.model.entity;
import com.rent.model.dto.UserDto;
import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //@Column(name = "Username")
    private String username;

    //@Column(name = "Password")
    private String password;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto toDto(){
        UserDto userDto = new UserDto();

        userDto.setUsername(this.username);
        userDto.setPassword(this.password);
        return userDto;
    }

    public User update( UserDto dto){
        this.username = dto.getUsername();
        this.password = dto.getPassword();
        return this;
    }
}