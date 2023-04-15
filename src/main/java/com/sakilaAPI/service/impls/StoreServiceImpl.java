package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Store;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.responses.StoreResponse;
import com.sakilaAPI.service.interfaces.StoreService;
import com.sakilaAPI.utils.mappers.StoreResponseMapper;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StoreServiceImpl implements StoreService {
    private static StoreServiceImpl storeService;

    private StoreServiceImpl(){}

    public static StoreService getStoreService(){
        if(storeService == null)
            storeService = new StoreServiceImpl();
        return storeService;
    }

    @Override
    public List<StoreResponse> getAllStores(){
        return RepositoryFactory.getInstance().createStoreRepository()
                .getAllEntities().stream()
                .map(StoreResponseMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public StoreResponse getStore(int id){
        Optional<Store> store = RepositoryFactory.getInstance().createStoreRepository()
                .getEntityById(id);
        if(store.isPresent()){
            return StoreResponseMapper.INSTANCE.toDto(store.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Store not found for ID: " + id );
        }
    }
}
