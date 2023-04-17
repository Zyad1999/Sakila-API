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
public class CustomerRequest implements Serializable {
    private Short storeId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer addressId;
}