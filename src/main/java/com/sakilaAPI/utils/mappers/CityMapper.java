package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.City;
import com.sakilaAPI.service.dtos.CityDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper( CityMapper.class );
    City toEntity(CityDto cityDto);

    CityDto toDto(City city);
}