package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.AddressDto;
import com.sakilaAPI.service.dtos.requests.ActorRequest;
import com.sakilaAPI.service.dtos.requests.AddressRequest;
import com.sakilaAPI.service.dtos.responses.ActorResponse;
import com.sakilaAPI.service.impls.ActorServiceImpl;
import com.sakilaAPI.service.impls.AddressServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("address")
public class Address {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AddressDto> getAllAddresses(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return AddressServiceImpl.getAddressService().getAllAddresses(limit, offset);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AddressDto getAddress(@PathParam("id") int id){
        return AddressServiceImpl.getAddressService().getAddress(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AddressDto addAddress(AddressRequest address){
        System.out.println(address);
        return AddressServiceImpl.getAddressService().addAddress(address);
    }

    @DELETE
    @Path("{id}")
    public Response deleteAddress(@PathParam("id") int id){
        AddressServiceImpl.getAddressService().deleteAddress(id);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AddressDto updateActor(AddressRequest address, @PathParam("id") int id){
        return AddressServiceImpl.getAddressService().updateAddress(address, id);
    }
}