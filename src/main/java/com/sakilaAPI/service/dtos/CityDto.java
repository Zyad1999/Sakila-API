package com.sakilaAPI.service.dtos;

import com.sakilaAPI.database.entities.City;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link City} entity
 */
@Data
public class CityDto implements Serializable {
    private final Integer id;
    private final String city;
    private final CountryDto country;
    private final Instant lastUpdate;
}