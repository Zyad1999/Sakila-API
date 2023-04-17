package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.Database;
import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.database.entities.City;
import com.sakilaAPI.database.entities.Language;
import com.sakilaAPI.database.repos.interfaces.ActorRepository;
import com.sakilaAPI.database.repos.interfaces.CityRepository;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class CityRepositoryImpl extends RepositoryImpl<City> implements CityRepository {

    public CityRepositoryImpl() {
        super(City.class);
    }

    @Override
    public Optional<City> getCity(String name){
        return Database.doInTransaction(entityManager -> {
            TypedQuery<City> query = entityManager.createQuery("SELECT e FROM City e "+
                    "where lower(e.city) = lower(:name)", City.class);
            query.setParameter("name",name);
            return Optional.ofNullable(query.getSingleResult());
        });
    }
}
