package com.sakilaAPI.database.repos.interfaces;

import com.sakilaAPI.exceptions.RepositoryException;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    T addEntity(T entity);

    Optional<T> getEntityById(Integer id);

    List<T> getAllEntities();

    void deleteEntityById(Integer id);

    T updateEntity(T entity) throws EntityNotFoundException, RepositoryException;
}
