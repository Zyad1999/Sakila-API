package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.FilmActor;
import com.sakilaAPI.service.dtos.FilmActorDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {FilmActorIdMapper.class})
public interface FilmActorMapper {
    FilmActor toEntity(FilmActorDto filmActorDto);

    FilmActorDto toDto(FilmActor filmActor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmActor partialUpdate(FilmActorDto filmActorDto, @MappingTarget FilmActor filmActor);
}