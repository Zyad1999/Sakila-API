package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.FilmCategoryId} entity
 */
@Data
public class FilmCategoryIdDto implements Serializable {
    private final Integer filmId;
    private final Short categoryId;
}