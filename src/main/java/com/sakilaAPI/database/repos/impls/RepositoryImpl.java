package com.sakilaAPI.database.repos.impls;

import com.sakilaAPI.database.Database;
import com.sakilaAPI.database.repos.interfaces.Repository;
import com.sakilaAPI.exceptions.RepositoryException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class RepositoryImpl<T> implements Repository<T>{

    private Class<T> entityClass;

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
            TypedQuery<T> query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
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
    public T updateEntity(T entity) throws EntityNotFoundException, RepositoryException {
        Database.doInTransactionWithoutResult(entityManager -> {
            try {
                entityManager.merge(entity);
            } catch (IllegalArgumentException e) {
                throw new EntityNotFoundException("Entity not found for ID: " + entity.getClass().getSimpleName() + "#" + entity.hashCode(), e);
            } catch (Exception e) {
                throw new RepositoryException("An error occurred while updating the entity: " + entity, e);
            }
        });
        return entity;
    }
}
