package com.rent.model.entity;

import com.rent.model.dto.RoleDto;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Admin")
    private boolean admin;

    @Column(name = "Client")
    private boolean client;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public RoleDto toDto(){
        RoleDto roleDto = new RoleDto();

        roleDto.setAdmin(this.admin);
        roleDto.setClient(this.client);
        return roleDto;
    }

    public Role update(RoleDto dto){
        this.admin = dto.isAdmin();
        this.client= dto.isClient();
        return this;
    }
}


