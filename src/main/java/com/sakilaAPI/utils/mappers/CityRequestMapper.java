package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.City;
import com.sakilaAPI.database.entities.Country;
import com.sakilaAPI.service.dtos.requests.CityRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CityRequestMapper {
    CityRequestMapper INSTANCE = Mappers.getMapper( CityRequestMapper.class );
    void updateEntity(CityRequest cityDto, @MappingTarget City city);
    @Mapping(target = "country", expression = "java(getCountry(cityDto.getCountryId()))")
    City toEntity(CityRequest cityDto);

    CityRequest toDto(City city);

    default Country getCountry(int countryId) {
        return Country.builder().id(countryId).build();
    }
}