package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Rental;
import com.sakilaAPI.service.dtos.RentalDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {InventoryMapper.class, StaffMapper.class})
public interface RentalMapper {
    RentalMapper INSTANCE = Mappers.getMapper( RentalMapper.class );
    Rental toEntity(RentalDto rentalDto);

    RentalDto toDto(Rental rental);
}