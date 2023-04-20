package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.InventoryDto;
import com.sakilaAPI.service.dtos.requests.AddFilmToStoreRequest;
import com.sakilaAPI.service.dtos.requests.StoreRequest;
import com.sakilaAPI.service.dtos.responses.StoreResponse;

import java.util.List;

public interface StoreService {
    List<StoreResponse> getAllStores(int limit, int offset);

    StoreResponse getStore(int id);

    StoreResponse addStore(StoreRequest store);

    void deleteStore(int id);

    StoreResponse updateStore(StoreRequest store, int id);

    InventoryDto addFilm(AddFilmToStoreRequest request);

    void removeFilm(Integer inventoryId);
}
