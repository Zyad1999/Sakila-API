package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Category} entity
 */
@Data
public class CategoryDto implements Serializable {
    private final Short id;
    private final String name;
    private final Instant lastUpdate;
    private final Set<FilmCategoryDto> filmCategories;
}