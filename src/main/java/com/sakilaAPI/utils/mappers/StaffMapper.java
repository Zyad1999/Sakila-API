package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Staff;
import com.sakilaAPI.database.entities.Store;
import com.sakilaAPI.service.dtos.StaffDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {AddressMapper.class, StoreMapper.class, StoreMapper.class})
public interface StaffMapper {
    Staff toEntity(StaffDto staffDto);

    StaffDto toDto(Staff staff);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Staff partialUpdate(StaffDto staffDto, @MappingTarget Staff staff);

    @AfterMapping
    default void linkManagedStore(@MappingTarget Staff staff) {
        Store managedStore = staff.getManagedStore();
        if (managedStore != null) {
            managedStore.setManagerStaff(staff);
        }
    }
}