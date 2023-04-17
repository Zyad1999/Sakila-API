package com.sakilaAPI.service.dtos;

import com.sakilaAPI.database.entities.Country;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Country} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class CountryDto implements Serializable {
    private Integer id;
    private String country;
}