package com.sakilaAPI.database.repos.interfaces;

import com.sakilaAPI.config.exceptions.BusinessException;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    T addEntity(T entity);

    Optional<T> getEntityById(Integer id);

    List<T> getAllEntities(int limit, int offset);

    void deleteEntityById(Integer id);

    T updateEntity(T entity) throws BusinessException;
}
