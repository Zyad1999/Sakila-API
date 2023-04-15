package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.CustomerDto;
import com.sakilaAPI.service.dtos.responses.ActorResponse;
import com.sakilaAPI.service.impls.ActorServiceImpl;
import com.sakilaAPI.service.impls.CustomerServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("customer")
public class Customer {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDto> getAllActor() {
        return CustomerServiceImpl.getCustomerService().getAllCustomers();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDto getActor(@PathParam("id") int id){
        return CustomerServiceImpl.getCustomerService().getCustomer(id);
    }
}