package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.City;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.CityDto;
import com.sakilaAPI.service.dtos.requests.CityRequest;
import com.sakilaAPI.service.interfaces.CityService;
import com.sakilaAPI.utils.mappers.*;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CityServiceImpl implements CityService {
    private static CityServiceImpl cityService;

    private CityServiceImpl(){}

    public static CityService getCityService(){
        if(cityService == null)
            cityService = new CityServiceImpl();
        return cityService;
    }

    @Override
    public List<CityDto> getAllCities(int limit, int offset){
        return RepositoryFactory.getInstance().createCityRepository()
                .getAllEntities(limit, offset).stream()
                .map(CityMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public CityDto getCity(int id){
        Optional<City> city = RepositoryFactory.getInstance().createCityRepository()
                .getEntityById(id);
        if(city.isPresent()){
            return CityMapper.INSTANCE.toDto(city.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"City not found for ID: " + id );
        }
    }

    @Override
    public CityDto getCity(String name) {
        Optional<City> city = RepositoryFactory.getInstance().createCityRepository()
                .getCity(name);
        if(city.isPresent()){
            return CityMapper.INSTANCE.toDto(city.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"City not found for name: " + name );
        }
    }

    @Override
    public CityDto addCity(CityRequest city){
        City cityEntity = CityRequestMapper.INSTANCE.toEntity(city);
        cityEntity.setLastUpdate(Instant.now());
        return CityMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createCityRepository().addEntity(
                        cityEntity
                )
        );
    }

    @Override
    public void deleteCity(int id){
        RepositoryFactory.getInstance().createCityRepository().deleteEntityById(id);
    }

    @Override
    public CityDto updateCity(CityRequest city, int id){
        Optional<City> cityEntity = RepositoryFactory.getInstance().createCityRepository()
                .getEntityById(id);
        if(cityEntity.isEmpty()){
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"city not found for ID: " + id );
        }
        CityRequestMapper.INSTANCE.updateEntity(city, cityEntity.get());
        return CityMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createCityRepository().updateEntity(
                        cityEntity.get()
                )
        );
    }
}
