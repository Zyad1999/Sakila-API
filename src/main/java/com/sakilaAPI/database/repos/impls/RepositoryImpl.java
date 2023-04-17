package com.sakilaAPI.database.repos.impls;

import com.sakilaAPI.database.Database;
import com.sakilaAPI.database.repos.interfaces.Repository;
import com.sakilaAPI.config.exceptions.BusinessException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.core.Response;
import jakarta.validation.ConstraintViolationException;

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
            try {
                entityManager.persist(entity);
            }catch (PersistenceException e) {
                System.out.println(e);
                if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                    throw new BusinessException(Response.Status.BAD_REQUEST.getReasonPhrase(),
                            Response.Status.BAD_REQUEST.getStatusCode(),
                            "Validation constraint violation: " + e.getCause().getMessage());
                } else {
                    System.out.println("persistance E");
                    System.out.println(e);
                    throw new BusinessException(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                            Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                            "An error occurred while adding the entity: " + entity);
                }
            }catch(ConstraintViolationException e){
                System.out.println(e);
                throw new BusinessException(Response.Status.BAD_REQUEST.getReasonPhrase(),
                        Response.Status.BAD_REQUEST.getStatusCode(),
                        "Please submit all required fields");
            } catch (Exception e) {
                System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
                System.out.println(e);
                throw new BusinessException(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                        Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()
                        ,"An error occurred while adding the entity: " + entity);
            }
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
    public List<T> getAllEntities(int limit, int offset) {
        return Database.doInTransaction(entityManager -> {
            TypedQuery<T> query = entityManager.createQuery("SELECT e FROM " +
                    entityClass.getSimpleName() + " e ", entityClass);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.getResultList();
        });
    }


    @Override
    public void deleteEntityById(Integer id) {
        Database.doInTransactionWithoutResult(entityManager -> {
            T entity = entityManager.find(entityClass, id);
            if (entity != null) {
                try {
                    entityManager.remove(entity);
                }catch (PersistenceException e) {
                    if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                        throw new BusinessException(Response.Status.BAD_REQUEST.getReasonPhrase(),
                                Response.Status.BAD_REQUEST.getStatusCode(),
                                "Validation constraint violation: " + e.getCause().getMessage());
                    } else {
                        throw new BusinessException(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                                Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                                "An error occurred while adding the entity: " + entity);
                    }
                }catch (Exception e) {
                    throw new BusinessException(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                            Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()
                            ,"An error occurred while deleting the entity: " + entity);
                }
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
            }catch (PersistenceException e) {
                if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                    throw new BusinessException(Response.Status.BAD_REQUEST.getReasonPhrase(),
                            Response.Status.BAD_REQUEST.getStatusCode(),
                            "Validation constraint violation: " + e.getCause().getMessage());
                } else {
                    throw new BusinessException(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                            Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                            "An error occurred while adding the entity: " + entity);
                }
            }catch(ConstraintViolationException e){
                throw new BusinessException(Response.Status.BAD_REQUEST.getReasonPhrase(),
                        Response.Status.BAD_REQUEST.getStatusCode(),
                        "empty fields are not allowed");
            } catch (Exception e) {
                throw new BusinessException(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                        Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()
                        ,"An error occurred while updating the entity: " + entity);
            }
        });
        return entity;
    }
}
