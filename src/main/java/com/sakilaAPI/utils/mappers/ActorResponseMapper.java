package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.database.entities.FilmActor;
import com.sakilaAPI.service.dtos.ActorDto;
import com.sakilaAPI.service.dtos.responses.ActorResponse;
import com.sakilaAPI.service.dtos.responses.BaseFilmResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

@Mapper
public interface ActorResponseMapper {
    ActorResponseMapper INSTANCE = Mappers.getMapper( ActorResponseMapper.class );
    void updateEntity(ActorResponse actorDto, @MappingTarget Actor actor);
    @Mapping(target = "filmActors", ignore = true)
    Actor toEntity(ActorResponse actorDto);

    @Mapping(target = "films", expression = "java(getFilms(actor.getFilmActors()))")
    ActorResponse toDto(Actor actor);

    default Set<BaseFilmResponse> getFilms(Set<FilmActor> filmActors) {
        Set<BaseFilmResponse> films = new HashSet<>();
        for (FilmActor filmActor : filmActors) {
            films.add(BaseFilmResponseMapper.INSTANCE.toDto(filmActor.getFilm()));
        }
        return films;
    }
}