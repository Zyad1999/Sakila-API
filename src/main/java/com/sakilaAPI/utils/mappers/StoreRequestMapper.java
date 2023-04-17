package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.*;
import com.sakilaAPI.service.dtos.requests.StoreRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StoreRequestMapper {
    StoreRequestMapper INSTANCE = Mappers.getMapper( StoreRequestMapper.class );
    void updateEntity(StoreRequest storeDto, @MappingTarget Store store);
    @Mapping(target = "address", expression = "java(getAddress(storeDto.getAddressId()))")
    @Mapping(target = "managerStaff", expression = "java(getManager(storeDto.getManagerId()))")
    Store toEntity(StoreRequest storeDto);

    StoreRequest toDto(Store store);

    default Address getAddress(int addressId) {
        return Address.builder().id(addressId).build();
    }

    default Staff getManager(short managerId) {
        return Staff.builder().id(managerId).build();
    }
}