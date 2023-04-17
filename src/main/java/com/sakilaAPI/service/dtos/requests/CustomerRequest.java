package com.sakilaAPI.service.dtos.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerRequest implements Serializable {
    private Short storeId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer addressId;
}