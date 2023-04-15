package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.FilmActor;
import com.sakilaAPI.database.entities.Inventory;
import com.sakilaAPI.database.entities.Store;
import com.sakilaAPI.service.dtos.FilmDto;
import com.sakilaAPI.service.dtos.StoreDto;
import com.sakilaAPI.service.dtos.responses.BaseFilmResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

@Mapper
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper( StoreMapper.class );
    Store toEntity(StoreDto storeDto);

    @Mapping(target = "films", expression = "java(getFilms(store.getInventories()))")
    StoreDto toDto(Store store);

    default Set<FilmDto> getFilms(Set<Inventory> inventories) {
        Set<FilmDto> films = new HashSet<>();
        for (Inventory inventory : inventories) {
            films.add(FilmMapper.INSTANCE.toDto(inventory.getFilm()));
        }
        return films;
    }
}