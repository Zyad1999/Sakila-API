package com.sakilaAPI.service.dtos.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class StoreRequest implements Serializable {
    private Integer addressId;
    private Short managerId;
}