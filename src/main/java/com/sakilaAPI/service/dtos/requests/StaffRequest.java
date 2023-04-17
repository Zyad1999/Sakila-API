package com.sakilaAPI.service.dtos.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class StaffRequest implements Serializable {
    private String firstName;
    private String lastName;
    private Integer addressId;
    private byte[] picture;
    private String email;
    private Short storeId;
    private String username;
    private String password;
}