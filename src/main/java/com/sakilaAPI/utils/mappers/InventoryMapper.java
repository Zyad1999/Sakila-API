package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Inventory;
import com.sakilaAPI.service.dtos.InventoryDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {FilmMapper.class, StoreMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper( InventoryMapper.class );
    Inventory toEntity(InventoryDto inventoryDto);

    InventoryDto toDto(Inventory inventory);
}