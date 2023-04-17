package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Address;
import com.sakilaAPI.database.entities.City;
import com.sakilaAPI.service.dtos.requests.AddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressRequestMapper {
    AddressRequestMapper INSTANCE = Mappers.getMapper( AddressRequestMapper.class );
    void updateEntity(AddressRequest addressDto, @MappingTarget Address address);
    @Mapping(target = "city", expression = "java(getCity(addressDto.getCityId()))")
    Address toEntity(AddressRequest addressDto);
    AddressRequest toDto(Address address);

    default City getCity(int cityId) {
        return City.builder().id(cityId).build();
    }
}