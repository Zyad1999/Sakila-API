package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.FilmCategory;
import com.sakilaAPI.service.dtos.FilmCategoryDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {FilmCategoryIdMapper.class})
public interface FilmCategoryMapper {
    FilmCategoryMapper INSTANCE = Mappers.getMapper( FilmCategoryMapper.class );
    FilmCategory toEntity(FilmCategoryDto filmCategoryDto);

    FilmCategoryDto toDto(FilmCategory filmCategory);

}