package com.sakilaAPI.service.dtos.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressRequest implements Serializable {
    private String address;
    private String address2;
    private String district;
    private Integer cityId;
    private String postalCode;
    private String phone;
}