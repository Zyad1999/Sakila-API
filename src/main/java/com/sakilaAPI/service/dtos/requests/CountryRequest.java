package com.sakilaAPI.service.dtos.requests;

import com.sakilaAPI.database.entities.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Country} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryRequest implements Serializable {
    private String country;
}