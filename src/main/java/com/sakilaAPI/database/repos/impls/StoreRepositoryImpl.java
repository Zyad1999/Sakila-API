package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.entities.Category;
import com.sakilaAPI.database.entities.Store;
import com.sakilaAPI.database.repos.interfaces.CategoryRepository;
import com.sakilaAPI.database.repos.interfaces.StoreRepository;

public class StoreRepositoryImpl extends RepositoryImpl<Store> implements StoreRepository {

    public StoreRepositoryImpl() {
        super(Store.class);
    }
}
