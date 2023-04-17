package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Address;
import com.sakilaAPI.database.entities.Customer;
import com.sakilaAPI.database.entities.Store;
import com.sakilaAPI.service.dtos.requests.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerRequestMapper {
    CustomerRequestMapper INSTANCE = Mappers.getMapper( CustomerRequestMapper.class );
    void updateEntity(CustomerRequest customerDto, @MappingTarget Customer customer);
    @Mapping(target = "address", expression = "java(getAddress(customerDto.getAddressId()))")
    @Mapping(target = "store", expression = "java(getStore(customerDto.getStoreId()))")
    Customer toEntity(CustomerRequest customerDto);

    CustomerRequest toDto(Customer customer);

    default Address getAddress(int addressId) {
        return Address.builder().id(addressId).build();
    }

    default Store getStore(short storeId) {
        return Store.builder().id(storeId).build();
    }
}