package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Film;
import com.sakilaAPI.database.entities.Language;
import com.sakilaAPI.database.enums.Rating;
import com.sakilaAPI.database.enums.SpecialFeatures;
import com.sakilaAPI.service.dtos.requests.FilmRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(uses = {LanguageMapper.class},nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FilmRequestMapper {
    FilmRequestMapper INSTANCE = Mappers.getMapper( FilmRequestMapper.class );
    void updateEntity(FilmRequest filmDto, @MappingTarget Film film);
    @Mapping(target = "language", expression = "java(getLanguage(filmDto.getLanguageId()))")
    @Mapping(target = "originalLanguage", expression = "java(getOriginalLanguage(filmDto))")
    @Mapping(target = "rating", expression = "java(getRating(filmDto.getRating()))")
    @Mapping(target = "specialFeatures", expression = "java(getFeatures(filmDto.getSpecialFeatures()))")
    Film toEntity(FilmRequest filmDto);

    @Mapping(target = "specialFeatures", ignore = true)
    FilmRequest toDto(Film film);

    default Language getLanguage(short languageId) {
        return Language.builder().id(languageId).build();
    }

    default Language getOriginalLanguage(FilmRequest filmDto) {
        if(filmDto == null){
            return null;
        }
        return Language.builder().id(filmDto.getOriginalLanguageId()).build();
    }

    default String getRating(Rating rating) {
        if (rating == null){
            return null;
        }
        return rating.getValue();
    }

    default String getFeatures(Set<SpecialFeatures> features) {
        if(features == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        SpecialFeatures[] featuresArray = features.toArray(new SpecialFeatures[features.size()]);
        for (int i = 0; i<featuresArray.length-1; i++) {
            sb.append(featuresArray[i].getValue()).append(",");
        }
        sb.append(featuresArray[featuresArray.length-1].getValue());
        System.out.println(sb);
        return sb.toString();
    }
}