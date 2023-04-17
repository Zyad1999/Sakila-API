package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Country;
import com.sakilaAPI.service.dtos.requests.CountryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CountryRequestMapper {
    CountryRequestMapper INSTANCE = Mappers.getMapper( CountryRequestMapper.class );
    Country toEntity(CountryRequest countryDto);
    void updateEntity(CountryRequest countryDto, @MappingTarget Country country);

    CountryRequest toDto(Country country);
}