package com.sakilaAPI.service.dtos.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class CityRequest implements Serializable {
    private String city;
    private Integer countryId;
}