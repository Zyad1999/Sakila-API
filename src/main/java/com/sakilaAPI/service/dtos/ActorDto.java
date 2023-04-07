package com.sakilaAPI.service.dtos;

import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.service.dtos.FilmActorDto;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link Actor} entity
 */
@Data
public class ActorDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final Instant lastUpdate;
    private final Set<FilmActorDto> filmActors;
}