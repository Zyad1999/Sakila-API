package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.database.entities.Inventory;
import com.sakilaAPI.database.entities.Store;
import com.sakilaAPI.service.dtos.ActorDto;
import com.sakilaAPI.service.dtos.StoreDto;
import com.sakilaAPI.service.dtos.responses.BaseFilmResponse;
import com.sakilaAPI.service.dtos.responses.BaseStoreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

@Mapper
public interface BaseStoreMapper {
    BaseStoreMapper INSTANCE = Mappers.getMapper( BaseStoreMapper.class );
    Store toEntity(BaseStoreResponse storeDto);

    BaseStoreResponse toDto(Store store);
}