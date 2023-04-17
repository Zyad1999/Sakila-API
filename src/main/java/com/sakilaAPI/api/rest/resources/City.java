package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.CityDto;
import com.sakilaAPI.service.dtos.requests.CategoryRequest;
import com.sakilaAPI.service.dtos.requests.CityRequest;
import com.sakilaAPI.service.dtos.responses.CategoryResponse;
import com.sakilaAPI.service.impls.CategoryServiceImpl;
import com.sakilaAPI.service.impls.CityServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("city")
public class City {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CityDto> getAllCities(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return CityServiceImpl.getCityService().getAllCities(limit, offset);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CityDto getCity(@PathParam("id") int id){
        return CityServiceImpl.getCityService().getCity(id);
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CityDto getCity(@PathParam("name") String name){
        return CityServiceImpl.getCityService().getCity(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CityDto addCity(CityRequest city){
        return CityServiceImpl.getCityService().addCity(city);
    }

    @DELETE
    @Path("{id}")
    public Response deleteCity(@PathParam("id") int id){
        CityServiceImpl.getCityService().deleteCity(id);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    public CityDto updateCity(CityRequest city, @PathParam("id") int id){
        return CityServiceImpl.getCityService().updateCity(city, id);
    }
}