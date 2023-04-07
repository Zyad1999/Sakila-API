package com.sakilaAPI.service.dtos;

import com.sakilaAPI.database.entities.Country;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Country} entity
 */
@Data
public class CountryDto implements Serializable {
    private final Integer id;
    private final String country;
    private final Instant lastUpdate;
}