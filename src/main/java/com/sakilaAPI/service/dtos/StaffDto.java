package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Staff} entity
 */
@Data
public class StaffDto implements Serializable {
    private final Short id;
    private final String firstName;
    private final String lastName;
    private final AddressDto address;
    private final byte[] picture;
    private final String email;
    private final StoreDto store;
    private final Boolean active;
    private final String username;
    private final String password;
    private final Instant lastUpdate;
    private final StoreDto managedStore;
}