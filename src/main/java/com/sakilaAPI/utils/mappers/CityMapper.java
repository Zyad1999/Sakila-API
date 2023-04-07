package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.City;
import com.sakilaAPI.service.dtos.CityDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CityMapper {
    City toEntity(CityDto cityDto);

    CityDto toDto(City city);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City partialUpdate(CityDto cityDto, @MappingTarget City city);
}