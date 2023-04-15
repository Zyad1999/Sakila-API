package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Country;
import com.sakilaAPI.service.dtos.CountryDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper( CountryMapper.class );
    Country toEntity(CountryDto countryDto);

    CountryDto toDto(Country country);
}