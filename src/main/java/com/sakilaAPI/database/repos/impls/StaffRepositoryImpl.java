package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.entities.Staff;
import com.sakilaAPI.database.entities.Store;
import com.sakilaAPI.database.repos.interfaces.StaffRepository;
import com.sakilaAPI.database.repos.interfaces.StoreRepository;

public class StaffRepositoryImpl extends RepositoryImpl<Staff> implements StaffRepository {

    public StaffRepositoryImpl() {
        super(Staff.class);
    }
}
