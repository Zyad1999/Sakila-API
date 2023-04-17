package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Country;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.CountryDto;
import com.sakilaAPI.service.dtos.requests.CountryRequest;
import com.sakilaAPI.service.interfaces.CountryService;
import com.sakilaAPI.utils.mappers.*;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountryServiceImpl implements CountryService {
    private static CountryServiceImpl countryService;

    private CountryServiceImpl(){}

    public static CountryService getCountryService(){
        if(countryService == null)
            countryService = new CountryServiceImpl();
        return countryService;
    }

    @Override
    public List<CountryDto> getAllCountries(int limit, int offset){
        return RepositoryFactory.getInstance().createCountryRepository()
                .getAllEntities(limit, offset).stream()
                .map(CountryMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public CountryDto getCountry(int id){
        Optional<Country> country = RepositoryFactory.getInstance().createCountryRepository()
                .getEntityById(id);
        if(country.isPresent()){
            return CountryMapper.INSTANCE.toDto(country.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Country not found for ID: " + id );
        }
    }

    @Override
    public CountryDto getCountry(String name) {
        Optional<Country> country = RepositoryFactory.getInstance().createCountryRepository().getCountry(name);
        if(country.isPresent()){
            return CountryMapper.INSTANCE.toDto(country.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Country not found for name: " + name );
        }
    }

    @Override
    public CountryDto addCountry(CountryRequest country){
        Country countryEntity = CountryRequestMapper.INSTANCE.toEntity(country);
        countryEntity.setLastUpdate(Instant.now());
        return CountryMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createCountryRepository().addEntity(
                        countryEntity
                )
        );
    }

    @Override
    public void deleteCountry(int id){
        RepositoryFactory.getInstance().createCountryRepository().deleteEntityById(id);
    }

    @Override
    public CountryDto updateCountry(CountryRequest country, int id){
        Optional<Country> countryEntity = RepositoryFactory.getInstance().createCountryRepository()
                .getEntityById(id);
        if(countryEntity.isEmpty()){
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"country not found for ID: " + id );
        }
        CountryRequestMapper.INSTANCE.updateEntity(country, countryEntity.get());
        return CountryMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createCountryRepository().updateEntity(
                        countryEntity.get()
                )
        );
    }
}
