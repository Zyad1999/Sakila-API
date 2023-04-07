package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.FilmActorId} entity
 */
@Data
public class FilmActorIdDto implements Serializable {
    private final Integer actorId;
    private final Integer filmId;
}