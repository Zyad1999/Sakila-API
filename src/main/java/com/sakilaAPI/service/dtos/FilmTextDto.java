package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.FilmText} entity
 */
@Data
public class FilmTextDto implements Serializable {
    private final Short id;
    private final String title;
    private final String description;
}