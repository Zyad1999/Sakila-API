package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.FilmActor} entity
 */
@Data
public class FilmActorDto implements Serializable {
    private final FilmActorIdDto id;
    private final Instant lastUpdate;
}