package com.sakilaAPI.service.dtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Film} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class FilmDto implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private Integer releaseYear;
    private LanguageDto language;
    private LanguageDto originalLanguage;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private Instant lastUpdate;
    private Set<FilmActorDto> filmActors;
    private Set<FilmCategoryDto> filmCategories;
}