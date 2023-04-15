package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.service.dtos.responses.BaseActorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaseActorResponseMapper {
    BaseActorResponseMapper INSTANCE = Mappers.getMapper( BaseActorResponseMapper.class );
    Actor toEntity(BaseActorResponse actorDto);

    BaseActorResponse toDto(Actor actor);
}