package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Store} entity
 */
@Data
public class StoreDto implements Serializable {
    private final Short id;
    private final AddressDto address;
    private final Instant lastUpdate;
}