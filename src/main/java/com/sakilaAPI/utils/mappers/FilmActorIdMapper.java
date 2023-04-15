package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.FilmActorId;
import com.sakilaAPI.service.dtos.FilmActorIdDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface FilmActorIdMapper {
    FilmActorIdMapper INSTANCE = Mappers.getMapper( FilmActorIdMapper.class );
    FilmActorId toEntity(FilmActorIdDto filmActorIdDto);

    FilmActorIdDto toDto(FilmActorId filmActorId);
}