package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.database.entities.Address;
import com.sakilaAPI.service.dtos.AddressDto;
import com.sakilaAPI.service.dtos.responses.ActorResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper( AddressMapper.class );
    void updateEntity(AddressDto addressDto, @MappingTarget Address address);
    Address toEntity(AddressDto addressDto);

    AddressDto toDto(Address address);
}