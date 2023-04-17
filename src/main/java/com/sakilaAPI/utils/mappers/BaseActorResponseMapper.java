package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.service.dtos.responses.BaseActorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaseActorResponseMapper {
    BaseActorResponseMapper INSTANCE = Mappers.getMapper( BaseActorResponseMapper.class );
    void updateEntity(BaseActorResponse actorDto, @MappingTarget Actor actor);
    @Mapping(target = "filmActors", ignore = true)
    Actor toEntity(BaseActorResponse actorDto);

    BaseActorResponse toDto(Actor actor);
}