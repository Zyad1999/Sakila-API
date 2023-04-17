package com.sakilaAPI.api.soap.services;

import com.sakilaAPI.service.dtos.requests.StoreRequest;
import com.sakilaAPI.service.dtos.responses.StoreResponse;
import com.sakilaAPI.service.impls.StoreServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

@WebService
public class Store {

    @WebMethod
    public List<StoreResponse> getAllStores(@WebParam(name = "limit") int limit, @WebParam(name = "offset") int offset) {
        return StoreServiceImpl.getStoreService().getAllStores(limit, offset);
    }

    @WebMethod
    public StoreResponse getStore(@WebParam(name = "id") int id){
        return StoreServiceImpl.getStoreService().getStore(id);
    }

    @WebMethod
    public StoreResponse addStore(StoreRequest store){
        return StoreServiceImpl.getStoreService().addStore(store);
    }

    @WebMethod
    public void deleteStore(@WebParam(name = "id") int id){
        StoreServiceImpl.getStoreService().deleteStore(id);
    }

    @WebMethod
    public StoreResponse updateStore(StoreRequest store, @WebParam(name = "id") int id){
        return StoreServiceImpl.getStoreService().updateStore(store, id);
    }
}
