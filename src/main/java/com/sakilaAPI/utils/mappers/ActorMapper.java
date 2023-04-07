package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.service.dtos.ActorDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {FilmActorMapper.class})
public interface ActorMapper {
    Actor toEntity(ActorDto actorDto);

    ActorDto toDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor partialUpdate(ActorDto actorDto, @MappingTarget Actor actor);

    @AfterMapping
    default void linkFilmActors(@MappingTarget Actor actor) {
        actor.getFilmActors().forEach(filmActor -> filmActor.setActor(actor));
    }
}