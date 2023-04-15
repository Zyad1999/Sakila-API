package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.entities.Inventory;
import com.sakilaAPI.database.entities.Staff;
import com.sakilaAPI.database.repos.interfaces.InventoryRepository;
import com.sakilaAPI.database.repos.interfaces.StaffRepository;

public class InventoryRepositoryImpl extends RepositoryImpl<Inventory> implements InventoryRepository {

    public InventoryRepositoryImpl() {
        super(Inventory.class);
    }
}
