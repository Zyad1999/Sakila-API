package com.sakilaAPI.database.repos.interfaces;

import com.sakilaAPI.database.entities.City;
import com.sakilaAPI.database.entities.Language;

import java.util.Optional;

public interface CityRepository extends Repository<City> {
    Optional<City> getCity(String name);
}
