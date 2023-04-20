package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.Database;
import com.sakilaAPI.database.entities.Inventory;
import com.sakilaAPI.database.entities.Store;
import com.sakilaAPI.database.repos.interfaces.StoreRepository;
import jakarta.persistence.Query;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class StoreRepositoryImpl extends RepositoryImpl<Store> implements StoreRepository {

    public StoreRepositoryImpl() {
        super(Store.class);
    }

    @Override
    public Integer filmInStock(Integer filmId, Integer storeId){
        return Database.doInTransaction(entityManager -> {
            StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("filmInStock");
            query.setParameter("p_film_id", filmId);
            query.setParameter("p_store_id", storeId);
            query.execute();
            Integer result = (Integer) query.getOutputParameterValue("p_film_count");
            System.out.println(result);
            return result;
        });
    }

    @Override
    public boolean inventoryInStock(Integer inventoryId){
        return Database.doInTransaction(entityManager -> {
            Query query = entityManager.createNamedQuery("Inventory.isInventoryInStock");
            query.setParameter("p_inventory_id", inventoryId);
            return (boolean) query.getSingleResult();
        });
    }

    @Override
    public List<Inventory> getFilmInventories(Integer filmId, Integer storeId){
        return Database.doInTransaction(entityManager -> {
            TypedQuery<Inventory> query = entityManager
                    .createQuery("select e from Inventory e " +
                    "where e.film.id = :filmId and e.store.id = :storeId", Inventory.class);
            query.setParameter("filmId",filmId);
            query.setParameter("storeId",storeId);
            return query.getResultList();
        });
    }
}
