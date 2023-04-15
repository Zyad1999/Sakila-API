package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.responses.StoreResponse;

import java.util.List;

public interface StoreService {
    List<StoreResponse> getAllStores();

    StoreResponse getStore(int id);
}
