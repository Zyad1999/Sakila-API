package com.sakilaAPI.database.repos.impls;

import com.sakilaAPI.database.Database;
import com.sakilaAPI.database.repos.interfaces.Repository;
import com.sakilaAPI.config.exceptions.BusinessException;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

public class RepositoryImpl<T> implements Repository<T>{

    private final Class<T> entityClass;

    public RepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T addEntity(T entity) {
        Database.doInTransactionWithoutResult(entityManager -> {
            entityManager.persist(entity);
        });
        return entity;
    }

    @Override
    public Optional<T> getEntityById(Integer id) {
        return Database.doInTransaction(entityManager -> {
            T entity = entityManager.find(entityClass, id);
            return Optional.ofNullable(entity);
        });
    }

    @Override
    public List<T> getAllEntities() {
        return Database.doInTransaction(entityManager -> {
            TypedQuery<T> query = entityManager.createQuery("SELECT e FROM " +
                    entityClass.getSimpleName() + " e ", entityClass);
            return query.getResultList();
        });
    }

    @Override
    public void deleteEntityById(Integer id) {
        Database.doInTransactionWithoutResult(entityManager -> {
            T entity = entityManager.find(entityClass, id);
            if (entity != null) {
                entityManager.remove(entity);
            }
        });
    }

    @Override
    public T updateEntity(T entity) throws BusinessException {
        Database.doInTransactionWithoutResult(entityManager -> {
            try {
                entityManager.merge(entity);
            } catch (IllegalArgumentException e) {
                throw new BusinessException(Response.Status.NOT_MODIFIED.getReasonPhrase(),
                        Response.Status.NOT_MODIFIED.getStatusCode()
                        ,"Entity not found for ID: " + entity.getClass().getSimpleName() + "#" + entity.hashCode());
            } catch (Exception e) {
                throw new BusinessException(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                        Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()
                        ,"An error occurred while updating the entity: " + entity);
            }
        });
        return entity;
    }
}
