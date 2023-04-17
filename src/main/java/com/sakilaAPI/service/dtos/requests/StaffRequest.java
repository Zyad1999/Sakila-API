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