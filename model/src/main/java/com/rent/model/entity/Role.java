package com.rent.model.entity;

import com.rent.model.dto.RoleDto;

import javax.persistence.*;

@Entity
public class Role {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Admin")
    private String  userName;

    @Column(name = "UserId")
    private Long userId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public RoleDto toRoleDto(){
        RoleDto roleDto = new RoleDto();

        roleDto.setUserName(this.userName);
        roleDto.setUserId(this.userId);
        roleDto.setId(this.id);
        return roleDto;
    }

    public Role update(RoleDto dto){
        this.userName = dto.getUserName();
        this.userId = dto.getUserId();
        this.id = dto.getId();
        return this;
    }

}


