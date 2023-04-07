package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Film} entity
 */
@Data
public class FilmDto implements Serializable {
    private final Integer id;
    private final String title;
    private final String description;
    private final Integer releaseYear;
    private final LanguageDto language;
    private final LanguageDto originalLanguage;
    private final Short rentalDuration;
    private final BigDecimal rentalRate;
    private final Integer length;
    private final BigDecimal replacementCost;
    private final String rating;
    private final String specialFeatures;
    private final Instant lastUpdate;
    private final Set<FilmActorDto> filmActors;
    private final Set<FilmCategoryDto> filmCategories;
}