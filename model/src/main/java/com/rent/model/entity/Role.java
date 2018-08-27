package com.rent.model.entity;

import com.rent.model.dto.RoleDto;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role")
    private String  role;



    public Role(){

    }

    public RoleDto toRoleDto(){
        RoleDto roleDto = new RoleDto();

        roleDto.setRole(this.role);
        roleDto.setId(this.id);
        return roleDto;
    }

    public Role update(RoleDto dto){
        this.role = dto.getRole();
        this.id = dto.getId();
        return this;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


