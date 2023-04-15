package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Store} entity
 */
@Data
public class StoreDto implements Serializable {
    private final Short id;
    private final AddressDto address;
    private final Instant lastUpdate;
    private final Set<FilmDto> films;
}