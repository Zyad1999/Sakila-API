package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Staff;
import com.sakilaAPI.database.entities.Store;
import com.sakilaAPI.service.dtos.StaffDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AddressMapper.class, StoreMapper.class, StoreMapper.class})
public interface StaffMapper {
    StaffMapper INSTANCE = Mappers.getMapper( StaffMapper.class );
    Staff toEntity(StaffDto staffDto);

    StaffDto toDto(Staff staff);
}