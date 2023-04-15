package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Film;
import com.sakilaAPI.service.dtos.responses.BaseFilmResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {LanguageMapper.class})
public interface BaseFilmResponseMapper {
    BaseFilmResponseMapper INSTANCE = Mappers.getMapper( BaseFilmResponseMapper.class );
    Film toEntity(BaseFilmResponse filmDto);

    BaseFilmResponse toDto(Film film);
}
