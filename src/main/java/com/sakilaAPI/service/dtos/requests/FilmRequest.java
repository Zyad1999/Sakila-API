package com.sakilaAPI.service.dtos.requests;

import com.sakilaAPI.database.enums.Rating;
import com.sakilaAPI.database.enums.SpecialFeatures;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
public class FilmRequest implements Serializable {
    private String title;
    private String description;
    private Integer releaseYear;
    private Short languageId;
    private Short originalLanguageId;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private BigDecimal replacementCost;
    private Rating rating;
    private Set<SpecialFeatures> specialFeatures;
    private Set<Integer> filmActorsIds;
    private Set<Short> filmCategoriesIds;
}