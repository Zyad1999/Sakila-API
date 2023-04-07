package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Rental;
import com.sakilaAPI.service.dtos.RentalDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {InventoryMapper.class, StaffMapper.class})
public interface RentalMapper {
    Rental toEntity(RentalDto rentalDto);

    RentalDto toDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental partialUpdate(RentalDto rentalDto, @MappingTarget Rental rental);
}