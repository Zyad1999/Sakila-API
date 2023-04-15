package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.StaffDto;
import com.sakilaAPI.service.dtos.StoreDto;
import com.sakilaAPI.service.dtos.responses.StoreResponse;
import com.sakilaAPI.service.impls.StaffServiceImpl;
import com.sakilaAPI.service.impls.StoreServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("store")
public class Store {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoreResponse> getAllStores() {
        return StoreServiceImpl.getStoreService().getAllStores();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StoreResponse getStore(@PathParam("id") int id){
        return StoreServiceImpl.getStoreService().getStore(id);
    }
}