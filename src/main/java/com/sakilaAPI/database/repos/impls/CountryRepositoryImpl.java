package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.Database;
import com.sakilaAPI.database.entities.City;
import com.sakilaAPI.database.entities.Country;
import com.sakilaAPI.database.entities.Language;
import com.sakilaAPI.database.repos.interfaces.CityRepository;
import com.sakilaAPI.database.repos.interfaces.CountryRepository;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class CountryRepositoryImpl extends RepositoryImpl<Country> implements CountryRepository {

    public CountryRepositoryImpl() {
        super(Country.class);
    }

    @Override
    public Optional<Country> getCountry(String name){
        return Database.doInTransaction(entityManager -> {
            TypedQuery<Country> query = entityManager.createQuery("SELECT e FROM Country e "+
                    "where lower(e.country) = lower(:name)", Country.class);
            query.setParameter("name",name);
            return Optional.ofNullable(query.getSingleResult());
        });
    }
}
