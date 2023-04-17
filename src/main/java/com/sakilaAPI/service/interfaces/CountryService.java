package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.CountryDto;
import com.sakilaAPI.service.dtos.requests.CountryRequest;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAllCountries(int limit, int offset);

    CountryDto getCountry(int id);

    CountryDto getCountry(String name);

    CountryDto addCountry(CountryRequest country);

    void deleteCountry(int id);

    CountryDto updateCountry(CountryRequest country, int id);
}
