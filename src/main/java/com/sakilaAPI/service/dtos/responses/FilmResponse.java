package com.sakilaAPI.service.dtos.responses;

import com.sakilaAPI.service.dtos.LanguageDto;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

@Data
public class FilmResponse implements Serializable {
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
    private final Set<BaseActorResponse> actors;
    private final Set<BaseCategoryResponse> categories;
}