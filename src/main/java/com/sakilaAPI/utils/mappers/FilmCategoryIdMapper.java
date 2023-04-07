package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.FilmCategoryId;
import com.sakilaAPI.service.dtos.FilmCategoryIdDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmCategoryIdMapper {
    FilmCategoryId toEntity(FilmCategoryIdDto filmCategoryIdDto);

    FilmCategoryIdDto toDto(FilmCategoryId filmCategoryId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategoryId partialUpdate(FilmCategoryIdDto filmCategoryIdDto, @MappingTarget FilmCategoryId filmCategoryId);
}