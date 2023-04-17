package com.sakilaAPI.api.soap.services;

import com.sakilaAPI.service.dtos.CountryDto;
import com.sakilaAPI.service.dtos.requests.CountryRequest;
import com.sakilaAPI.service.impls.CountryServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class Country {

    @WebMethod
    public CountryDto getCountry(@WebParam(name = "id") int id){
        return CountryServiceImpl.getCountryService().getCountry(id);
    }

    @WebMethod
    public List<CountryDto> getAllCountries(@WebParam(name = "limit") int limit, @WebParam(name = "offset") int offset) {
        return CountryServiceImpl.getCountryService().getAllCountries(limit, offset);
    }

    @WebMethod
    public CountryDto getCountryByName(@WebParam(name = "name") String name){
        return CountryServiceImpl.getCountryService().getCountry(name);
    }

    @WebMethod
    public CountryDto addCountry(CountryRequest country){
        return CountryServiceImpl.getCountryService().addCountry(country);
    }

    @WebMethod
    public void deleteCountry(@WebParam(name = "id") int id){
        CountryServiceImpl.getCountryService().deleteCountry(id);
    }

    @WebMethod
    public CountryDto updateCountry(CountryRequest country, @WebParam(name = "id") int id){
        return CountryServiceImpl.getCountryService().updateCountry(country, id);
    }
}
