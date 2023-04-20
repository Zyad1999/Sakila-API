package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Film;
import com.sakilaAPI.database.entities.Inventory;
import com.sakilaAPI.database.entities.Store;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.InventoryDto;
import com.sakilaAPI.service.dtos.requests.AddFilmToStoreRequest;
import com.sakilaAPI.service.dtos.requests.StoreRequest;
import com.sakilaAPI.service.dtos.responses.StoreResponse;
import com.sakilaAPI.service.interfaces.StoreService;
import com.sakilaAPI.utils.mappers.*;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
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
    public List<StoreResponse> getAllStores(int limit, int offset){
        return RepositoryFactory.getInstance().createStoreRepository()
                .getAllEntities(limit, offset).stream()
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

    @Override
    public StoreResponse addStore(StoreRequest store){
        Store storeEntity = StoreRequestMapper.INSTANCE.toEntity(store);
        storeEntity.setLastUpdate(Instant.now());
        return StoreResponseMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createStoreRepository().addEntity(
                        storeEntity
                )
        );
    }

    @Override
    public void deleteStore(int id){
        RepositoryFactory.getInstance().createStoreRepository().deleteEntityById(id);
    }

    @Override
    public StoreResponse updateStore(StoreRequest store, int id){
        Optional<Store> storeEntity = RepositoryFactory.getInstance().createStoreRepository()
                .getEntityById(id);
        if(storeEntity.isEmpty()){
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Store not found for ID: " + id );
        }
        StoreRequestMapper.INSTANCE.updateEntity(store, storeEntity.get());
        return StoreResponseMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createStoreRepository().updateEntity(
                        storeEntity.get()
                )
        );
    }

    @Override
    public InventoryDto addFilm(AddFilmToStoreRequest request){
        Inventory inventory = Inventory.builder()
                .film(Film.builder().id(request.getFilmId()).build())
                .store(Store.builder().id(request.getStoreId()).build())
                .lastUpdate(Instant.now())
                .build();
        return InventoryMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createRepository(Inventory.class)
                        .addEntity(inventory)
        );
    }

    @Override
    public void removeFilm(Integer inventoryId){
        RepositoryFactory.getInstance().createRepository(Inventory.class)
                        .deleteEntityById(inventoryId);
    }
}
