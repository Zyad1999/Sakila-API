package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Staff;
import com.sakilaAPI.service.dtos.StaffDto;
import com.sakilaAPI.service.dtos.responses.StaffResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AddressMapper.class, BaseStoreMapper.class})
public interface StaffResponseMapper {
    StaffResponseMapper INSTANCE = Mappers.getMapper( StaffResponseMapper.class );
    Staff toEntity(StaffResponse staffDto);

    StaffResponse toDto(Staff staff);
}