package com.sakilaAPI.service.dtos.responses;

import com.sakilaAPI.service.dtos.AddressDto;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class StaffResponse implements Serializable {
    private Short id;
    private String firstName;
    private String lastName;
    private AddressDto address;
    private byte[] picture;
    private String email;
    private BaseStoreResponse store;
    private Boolean active;
    private String username;
    private String password;
    private Instant lastUpdate;
    private BaseStoreResponse managedStore;
}