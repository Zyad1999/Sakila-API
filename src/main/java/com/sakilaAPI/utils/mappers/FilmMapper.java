package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Film;
import com.sakilaAPI.service.dtos.FilmDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {LanguageMapper.class, FilmActorMapper.class, FilmCategoryMapper.class})
public interface FilmMapper {
    FilmMapper INSTANCE = Mappers.getMapper( FilmMapper.class );
    Film toEntity(FilmDto filmDto);

    FilmDto toDto(Film film);
}