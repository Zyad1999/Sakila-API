package com.sakilaAPI.service.dtos.requests;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class CityRequest implements Serializable {
    private String city;
    private Integer countryId;
}