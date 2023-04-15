package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Category;
import com.sakilaAPI.database.entities.FilmCategory;
import com.sakilaAPI.service.dtos.responses.BaseFilmResponse;
import com.sakilaAPI.service.dtos.responses.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

@Mapper(uses = {FilmCategoryMapper.class})
public interface CategoryResponseMapper {
    CategoryResponseMapper INSTANCE = Mappers.getMapper( CategoryResponseMapper.class );
    Category toEntity(CategoryResponse categoryDto);

    @Mapping(target = "films", expression = "java(getFilms(category.getFilmCategories()))")
    CategoryResponse toDto(Category category);

    default Set<BaseFilmResponse> getFilms(Set<FilmCategory> filmCategories) {
        Set<BaseFilmResponse> films = new HashSet<>();
        for (FilmCategory filmCategory : filmCategories) {
            films.add(BaseFilmResponseMapper.INSTANCE.toDto(filmCategory.getFilm()));
        }
        return films;
    }
}