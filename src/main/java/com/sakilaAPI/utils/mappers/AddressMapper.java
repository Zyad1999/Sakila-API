package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Address;
import com.sakilaAPI.service.dtos.AddressDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper( AddressMapper.class );
    Address toEntity(AddressDto addressDto);

    AddressDto toDto(Address address);
}