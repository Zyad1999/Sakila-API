package com.sakilaAPI.service.dtos;

import com.sakilaAPI.database.entities.City;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link City} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class CityDto implements Serializable {
    private Integer id;
    private String city;
    private CountryDto country;
    private Instant lastUpdate;
}