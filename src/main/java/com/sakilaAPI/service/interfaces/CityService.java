package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.CityDto;
import com.sakilaAPI.service.dtos.requests.CityRequest;

import java.util.List;

public interface CityService {
    List<CityDto> getAllCities(int limit, int offset);

    CityDto getCity(int id);

    CityDto getCity(String name);

    CityDto addCity(CityRequest city);

    void deleteCity(int id);

    CityDto updateCity(CityRequest city, int id);
}
