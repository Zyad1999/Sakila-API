package com.sakilaAPI.api.soap.services;

import com.sakilaAPI.service.dtos.requests.CustomerRequest;
import com.sakilaAPI.service.dtos.responses.CustomerResponse;
import com.sakilaAPI.service.impls.CustomerServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;

@WebService
public class Customer {

    @WebMethod
    public List<CustomerResponse> getAllCustomers(@WebParam(name = "limit") int limit, @WebParam(name = "offset") int offset) {
        return CustomerServiceImpl.getCustomerService().getAllCustomers(limit, offset);
    }

    @WebMethod
    public CustomerResponse addCustomer(CustomerRequest customer){
        return CustomerServiceImpl.getCustomerService().addCustomer(customer);
    }

    @WebMethod
    public Response deleteCustomer(@WebParam(name = "id") int id){
        CustomerServiceImpl.getCustomerService().deleteCustomer(id);
        return Response.ok().build();
    }

    @WebMethod
    public CustomerResponse updateCustomer(CustomerRequest customer, @WebParam(name = "id") int id){
        return CustomerServiceImpl.getCustomerService().updateCustomer(customer, id);
    }

    @WebMethod
    public CustomerResponse getCustomer(@WebParam(name = "id") int id){
        return CustomerServiceImpl.getCustomerService().getCustomer(id);
    }
}
