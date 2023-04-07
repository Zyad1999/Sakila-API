package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.FilmActorId;
import com.sakilaAPI.service.dtos.FilmActorIdDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmActorIdMapper {
    FilmActorId toEntity(FilmActorIdDto filmActorIdDto);

    FilmActorIdDto toDto(FilmActorId filmActorId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmActorId partialUpdate(FilmActorIdDto filmActorIdDto, @MappingTarget FilmActorId filmActorId);
}