package com.sakilaAPI.service.dtos.responses;

import com.sakilaAPI.service.dtos.LanguageDto;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class FilmResponse implements Serializable {
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
    private Set<BaseActorResponse> actors;
    private Set<BaseCategoryResponse> categories;
}