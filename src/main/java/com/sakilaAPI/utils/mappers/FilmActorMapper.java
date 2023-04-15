package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.FilmActor;
import com.sakilaAPI.service.dtos.FilmActorDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper( uses = FilmActorIdMapper.class)
public interface FilmActorMapper {

    FilmActorMapper INSTANCE = Mappers.getMapper( FilmActorMapper.class );
    FilmActor toEntity(FilmActorDto filmActorDto);

    FilmActorDto toDto(FilmActor filmActor);
}