package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.RentalDto;
import com.sakilaAPI.service.dtos.requests.CustomerRequest;
import com.sakilaAPI.service.dtos.requests.RentFilmRequest;
import com.sakilaAPI.service.dtos.responses.CustomerResponse;
import com.sakilaAPI.service.impls.CustomerServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("customer")
public class Customer {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerResponse> getAllCustomers(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return CustomerServiceImpl.getCustomerService().getAllCustomers(limit, offset);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerResponse getCustomer(@PathParam("id") int id){
        return CustomerServiceImpl.getCustomerService().getCustomer(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CustomerResponse addCustomer(CustomerRequest customer){
        return CustomerServiceImpl.getCustomerService().addCustomer(customer);
    }

    @DELETE
    @Path("{id}")
    public Response deleteCustomer(@PathParam("id") int id){
        CustomerServiceImpl.getCustomerService().deleteCustomer(id);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CustomerResponse updateCustomer(CustomerRequest customer, @PathParam("id") int id){
        return CustomerServiceImpl.getCustomerService().updateCustomer(customer, id);
    }

    @POST
    @Path("rent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RentalDto rentFilm(RentFilmRequest request){
        return CustomerServiceImpl.getCustomerService().rentFilm(request);
    }

    @PUT
    @Path("rent/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RentalDto returnFilm(@PathParam("id") int id){
        return CustomerServiceImpl.getCustomerService().returnFilm(id);
    }
}