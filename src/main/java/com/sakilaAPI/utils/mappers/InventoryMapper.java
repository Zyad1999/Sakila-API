package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Inventory;
import com.sakilaAPI.service.dtos.InventoryDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {FilmMapper.class, StoreMapper.class})
public interface InventoryMapper {
    Inventory toEntity(InventoryDto inventoryDto);

    InventoryDto toDto(Inventory inventory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Inventory partialUpdate(InventoryDto inventoryDto, @MappingTarget Inventory inventory);
}