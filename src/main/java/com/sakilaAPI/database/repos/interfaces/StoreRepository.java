package com.sakilaAPI.database.repos.interfaces;

import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.database.entities.Inventory;
import com.sakilaAPI.database.entities.Store;

import java.util.List;

public interface StoreRepository extends Repository<Store> {
    Integer filmInStock(Integer filmId, Integer storeId);

    boolean inventoryInStock(Integer inventoryId);

    List<Inventory> getFilmInventories(Integer filmId, Integer storeId);
}
