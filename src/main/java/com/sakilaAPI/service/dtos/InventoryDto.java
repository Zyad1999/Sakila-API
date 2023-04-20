package com.sakilaAPI.service.dtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Inventory} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class InventoryDto implements Serializable {
    private Integer id;
    private FilmDto film;
    private StoreDto store;
    private Instant lastUpdate;
}