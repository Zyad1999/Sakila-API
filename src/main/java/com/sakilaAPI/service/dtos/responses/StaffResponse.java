package com.sakilaAPI.service.dtos.responses;

import com.sakilaAPI.service.dtos.AddressDto;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class StaffResponse implements Serializable {
    private final Short id;
    private final String firstName;
    private final String lastName;
    private final AddressDto address;
    private final byte[] picture;
    private final String email;
    private final BaseStoreResponse store;
    private final Boolean active;
    private final String username;
    private final String password;
    private final Instant lastUpdate;
    private final BaseStoreResponse managedStore;
}