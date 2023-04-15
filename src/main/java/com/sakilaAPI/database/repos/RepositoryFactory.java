package com.sakilaAPI.database.repos;

import com.sakilaAPI.database.repos.impls.*;
import com.sakilaAPI.database.repos.interfaces.*;

import java.lang.reflect.ParameterizedType;

public class RepositoryFactory {
    private static RepositoryFactory instance;

    private RepositoryFactory() {}

    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }

    public <T> Repository<T> createRepository(Class<T> type){
        return new RepositoryImpl<T>(type);
    }
    public ActorRepository createActorRepository(){
        return new ActorRepositoryImpl();
    }
    public CategoryRepository createCategoryRepository(){
        return new CategoryRepositoryImpl();
    }
    public FilmRepository createFilmRepository(){
        return new FilmRepositoryImpl();
    }
    public StoreRepository createStoreRepository(){ return new StoreRepositoryImpl();}
    public CustomerRepository createCustomerRepository(){ return new CustomerRepositoryImpl();}
    public LanguageRepository createLanguageRepository(){ return new LanguageRepositoryImpl();}
    public StaffRepository createStaffRepository(){ return new StaffRepositoryImpl();}
}
