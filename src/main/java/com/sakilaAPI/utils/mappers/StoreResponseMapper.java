package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Inventory;
import com.sakilaAPI.database.entities.Store;
import com.sakilaAPI.service.dtos.FilmDto;
import com.sakilaAPI.service.dtos.StoreDto;
import com.sakilaAPI.service.dtos.responses.BaseFilmResponse;
import com.sakilaAPI.service.dtos.responses.StoreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

@Mapper
public interface StoreResponseMapper {
    StoreResponseMapper INSTANCE = Mappers.getMapper( StoreResponseMapper.class );
    Store toEntity(StoreResponse storeDto);

    @Mapping(target = "films", expression = "java(getFilms(store.getInventories()))")
    StoreResponse toDto(Store store);

    default Set<BaseFilmResponse> getFilms(Set<Inventory> inventories) {
        Set<BaseFilmResponse> films = new HashSet<>();
        for (Inventory inventory : inventories) {
            films.add(BaseFilmResponseMapper.INSTANCE.toDto(inventory.getFilm()));
        }
        return films;
    }
}