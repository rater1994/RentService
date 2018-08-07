package com.rent.model.dto;


import java.util.Objects;

public class RoleDto {

    private boolean admin;
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


}

