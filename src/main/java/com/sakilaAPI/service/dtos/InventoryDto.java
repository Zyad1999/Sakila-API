package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Inventory} entity
 */
@Data
public class InventoryDto implements Serializable {
    private final Integer id;
    private final FilmDto film;
    private final StoreDto store;
    private final Instant lastUpdate;
}