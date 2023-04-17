package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Customer;
import com.sakilaAPI.service.dtos.CustomerDto;
import com.sakilaAPI.service.dtos.responses.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerResponseMapper {
    CustomerResponseMapper INSTANCE = Mappers.getMapper( CustomerResponseMapper.class );
    Customer toEntity(CustomerResponse customerDto);

    CustomerResponse toDto(Customer customer);
}