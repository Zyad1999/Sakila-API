package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Address;
import com.sakilaAPI.database.entities.Staff;
import com.sakilaAPI.database.entities.Store;
import com.sakilaAPI.service.dtos.requests.StaffRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AddressMapper.class, BaseStoreMapper.class},nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StaffRequestMapper {
    StaffRequestMapper INSTANCE = Mappers.getMapper( StaffRequestMapper.class );
    void updateEntity(StaffRequest staffDto, @MappingTarget Staff staff);
    @Mapping(target = "address", expression = "java(getAddress(staffDto.getAddressId()))")
    @Mapping(target = "store", expression = "java(getStore(staffDto.getStoreId()))")
    Staff toEntity(StaffRequest staffDto);

    StaffRequest toDto(Staff staff);

    default Address getAddress(int addressId) {
        return Address.builder().id(addressId).build();
    }

    default Store getStore(short storeId) {
        return Store.builder().id(storeId).build();
    }
}