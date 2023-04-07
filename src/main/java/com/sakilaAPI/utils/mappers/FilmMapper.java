package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Film;
import com.sakilaAPI.service.dtos.FilmDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {LanguageMapper.class, FilmActorMapper.class, FilmCategoryMapper.class})
public interface FilmMapper {
    Film toEntity(FilmDto filmDto);

    FilmDto toDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film partialUpdate(FilmDto filmDto, @MappingTarget Film film);

    @AfterMapping
    default void linkFilmActors(@MappingTarget Film film) {
        film.getFilmActors().forEach(filmActor -> filmActor.setFilm(film));
    }

    @AfterMapping
    default void linkFilmCategories(@MappingTarget Film film) {
        film.getFilmCategories().forEach(filmCategory -> filmCategory.setFilm(film));
    }
}