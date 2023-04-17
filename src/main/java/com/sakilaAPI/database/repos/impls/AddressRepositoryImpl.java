package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.database.entities.Address;
import com.sakilaAPI.database.repos.interfaces.ActorRepository;
import com.sakilaAPI.database.repos.interfaces.AddressRepository;

public class AddressRepositoryImpl extends RepositoryImpl<Address> implements AddressRepository {

    public AddressRepositoryImpl() {
        super(Address.class);
    }
}
