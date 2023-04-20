package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.InventoryDto;
import com.sakilaAPI.service.dtos.requests.AddFilmToStoreRequest;
import com.sakilaAPI.service.dtos.requests.StaffRequest;
import com.sakilaAPI.service.dtos.requests.StoreRequest;
import com.sakilaAPI.service.dtos.responses.StaffResponse;
import com.sakilaAPI.service.dtos.responses.StoreResponse;
import com.sakilaAPI.service.impls.StaffServiceImpl;
import com.sakilaAPI.service.impls.StoreServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("store")
public class Store {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoreResponse> getAllStores(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return StoreServiceImpl.getStoreService().getAllStores(limit, offset);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StoreResponse getStore(@PathParam("id") int id){
        return StoreServiceImpl.getStoreService().getStore(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public StoreResponse addStore(StoreRequest store){
        return StoreServiceImpl.getStoreService().addStore(store);
    }

    @DELETE
    @Path("{id}")
    public Response deleteStore(@PathParam("id") int id){
        StoreServiceImpl.getStoreService().deleteStore(id);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public StoreResponse updateStore(StoreRequest store, @PathParam("id") int id){
        return StoreServiceImpl.getStoreService().updateStore(store, id);
    }

    @POST
    @Path("inventory")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public InventoryDto addFilmToStore(AddFilmToStoreRequest request){
        return StoreServiceImpl.getStoreService().addFilm(request);
    }

    @DELETE
    @Path("inventory/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeFilmFromStore(@PathParam("id") int id){
        StoreServiceImpl.getStoreService().removeFilm(id);
        return Response.ok().build();
    }
}