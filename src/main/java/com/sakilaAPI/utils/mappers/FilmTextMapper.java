package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.FilmText;
import com.sakilaAPI.service.dtos.FilmTextDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilmTextMapper {
    FilmTextMapper INSTANCE = Mappers.getMapper( FilmTextMapper.class );
    FilmText toEntity(FilmTextDto filmTextDto);

    FilmTextDto toDto(FilmText filmText);
}