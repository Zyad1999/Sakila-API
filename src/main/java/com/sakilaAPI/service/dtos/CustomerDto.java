package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Customer} entity
 */
@Data
public class CustomerDto implements Serializable {
    private final Integer id;
    private final StoreDto store;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final AddressDto address;
    private final Boolean active;
    private final Instant createDate;
    private final Instant lastUpdate;
}