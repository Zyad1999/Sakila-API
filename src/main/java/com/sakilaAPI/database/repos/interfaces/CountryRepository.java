package com.sakilaAPI.database.repos.interfaces;

import com.sakilaAPI.database.entities.Country;
import com.sakilaAPI.database.entities.Language;

import java.util.Optional;

public interface CountryRepository extends Repository<Country> {
    Optional<Country> getCountry(String name);
}
