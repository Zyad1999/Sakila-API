package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.FilmCategory} entity
 */
@Data
public class FilmCategoryDto implements Serializable {
    private final FilmCategoryIdDto id;
    private final Instant lastUpdate;
}