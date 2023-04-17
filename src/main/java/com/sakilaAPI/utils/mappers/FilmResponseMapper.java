package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Film;
import com.sakilaAPI.database.entities.FilmActor;
import com.sakilaAPI.database.entities.FilmCategory;
import com.sakilaAPI.service.dtos.responses.BaseActorResponse;
import com.sakilaAPI.service.dtos.responses.BaseCategoryResponse;
import com.sakilaAPI.service.dtos.responses.FilmResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

@Mapper(uses = {LanguageMapper.class, FilmActorMapper.class, FilmCategoryMapper.class})
public interface FilmResponseMapper {
    FilmResponseMapper INSTANCE = Mappers.getMapper( FilmResponseMapper.class );
    Film toEntity(FilmResponse filmDto);

    @Mapping(target = "actors", expression = "java(getActors(film.getFilmActors()))")
    @Mapping(target = "categories", expression = "java(getCategories(film.getFilmCategories()))")
    FilmResponse toDto(Film film);

    default Set<BaseActorResponse> getActors(Set<FilmActor> filmActors) {
        if(filmActors == null){
            return null;
        }
        Set<BaseActorResponse> actors = new HashSet<>();
        for (FilmActor filmActor : filmActors) {
            actors.add(BaseActorResponseMapper.INSTANCE.toDto(filmActor.getActor()));
        }
        return actors;
    }

    default Set<BaseCategoryResponse> getCategories(Set<FilmCategory> filmCategories) {
        if(filmCategories == null){
            return null;
        }
        Set<BaseCategoryResponse> categories = new HashSet<>();
        for (FilmCategory filmCategory : filmCategories) {
            categories.add(BaseCategoryResponseMapper.INSTANCE.toDto(filmCategory.getCategory()));
        }
        return categories;
    }
}