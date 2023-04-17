package com.sakilaAPI.api.soap.services;

import com.sakilaAPI.service.dtos.AddressDto;
import com.sakilaAPI.service.dtos.requests.AddressRequest;
import com.sakilaAPI.service.impls.AddressServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

@WebService
public class Address {

    @WebMethod
    public List<AddressDto> getAllAddresses(@WebParam(name = "limit") int limit, @WebParam(name = "offset") int offset) {
        return AddressServiceImpl.getAddressService().getAllAddresses(limit, offset);
    }

    @WebMethod
    public AddressDto getAddress(@WebParam(name = "id") int id){
        return AddressServiceImpl.getAddressService().getAddress(id);
    }

    @WebMethod
    public AddressDto addAddress(AddressRequest address){
        return AddressServiceImpl.getAddressService().addAddress(address);
    }

    @WebMethod
    public void deleteAddress(@WebParam(name = "id") int id){
        AddressServiceImpl.getAddressService().deleteAddress(id);
    }

    @WebMethod
    public AddressDto updateActor(AddressRequest address, @WebParam(name = "id") int id){
        return AddressServiceImpl.getAddressService().updateAddress(address, id);
    }
}
