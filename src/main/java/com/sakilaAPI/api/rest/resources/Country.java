package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.CityDto;
import com.sakilaAPI.service.dtos.CountryDto;
import com.sakilaAPI.service.dtos.requests.CityRequest;
import com.sakilaAPI.service.dtos.requests.CountryRequest;
import com.sakilaAPI.service.impls.CityServiceImpl;
import com.sakilaAPI.service.impls.CountryServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("country")
public class Country {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryDto> getAllCities(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return CountryServiceImpl.getCountryService().getAllCountries(limit, offset);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CountryDto getCountry(@PathParam("id") int id){
        return CountryServiceImpl.getCountryService().getCountry(id);
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CountryDto getCity(@PathParam("name") String name){
        return CountryServiceImpl.getCountryService().getCountry(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CountryDto addCountry(CountryRequest country){
        return CountryServiceImpl.getCountryService().addCountry(country);
    }

    @DELETE
    @Path("{id}")
    public Response deleteCountry(@PathParam("id") int id){
        CountryServiceImpl.getCountryService().deleteCountry(id);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    public CountryDto updateCountry(CountryRequest country, @PathParam("id") int id){
        return CountryServiceImpl.getCountryService().updateCountry(country, id);
    }
}