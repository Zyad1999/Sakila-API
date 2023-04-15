package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.service.dtos.ActorDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = FilmActorMapper.class)
public interface ActorMapper {
    ActorMapper INSTANCE = Mappers.getMapper( ActorMapper.class );
    Actor toEntity(ActorDto actorDto);

    ActorDto toDto(Actor actor);
}