package com.sakilaAPI.api.soap.services;

import com.sakilaAPI.service.dtos.CityDto;
import com.sakilaAPI.service.dtos.requests.CityRequest;
import com.sakilaAPI.service.impls.CityServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

@WebService
public class City {

    @WebMethod
    public List<CityDto> getAllCities(@WebParam(name = "limit") int limit, @WebParam(name = "offset") int offset) {
        return CityServiceImpl.getCityService().getAllCities(limit, offset);
    }

    @WebMethod
    public CityDto getCity(@WebParam(name = "id") int id){
        return CityServiceImpl.getCityService().getCity(id);
    }

    @WebMethod
    public CityDto getCityByName(@WebParam(name = "name") String name){
        return CityServiceImpl.getCityService().getCity(name);
    }

    @WebMethod
    public CityDto addCity(CityRequest city){
        return CityServiceImpl.getCityService().addCity(city);
    }

    @WebMethod
    public void deleteCity(@WebParam(name = "id") int id){
        CityServiceImpl.getCityService().deleteCity(id);
    }

    @WebMethod
    public CityDto updateCity(CityRequest city, @WebParam(name = "id") int id){
        return CityServiceImpl.getCityService().updateCity(city, id);
    }
}
