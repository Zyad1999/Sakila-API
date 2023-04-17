package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.service.dtos.requests.ActorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ActorRequestMapper {
    ActorRequestMapper INSTANCE = Mappers.getMapper( ActorRequestMapper.class );
    void updateEntity(ActorRequest actorDto, @MappingTarget Actor actor);
    @Mapping(target = "filmActors", ignore = true)
    Actor toEntity(ActorRequest actorDto);
    ActorRequest toDto(Actor actor);
}