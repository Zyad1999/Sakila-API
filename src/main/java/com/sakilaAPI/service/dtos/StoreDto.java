package com.sakilaAPI.service.dtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Store} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class StoreDto implements Serializable {
    private Short id;
    private AddressDto address;
    private Instant lastUpdate;
    private Set<FilmDto> films;
}