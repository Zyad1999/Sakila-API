package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Customer;
import com.sakilaAPI.service.dtos.CustomerDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );
    Customer toEntity(CustomerDto customerDto);

    CustomerDto toDto(Customer customer);
}