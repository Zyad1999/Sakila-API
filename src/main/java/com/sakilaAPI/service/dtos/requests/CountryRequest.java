package com.sakilaAPI.service.dtos.requests;

import com.sakilaAPI.database.entities.Country;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Country} entity
 */
@Data
public class CountryRequest implements Serializable {
    private String country;
}