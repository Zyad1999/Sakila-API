package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.FilmCategoryId;
import com.sakilaAPI.service.dtos.FilmCategoryIdDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface FilmCategoryIdMapper {
    FilmCategoryIdMapper INSTANCE = Mappers.getMapper( FilmCategoryIdMapper.class );
    FilmCategoryId toEntity(FilmCategoryIdDto filmCategoryIdDto);

    FilmCategoryIdDto toDto(FilmCategoryId filmCategoryId);
}