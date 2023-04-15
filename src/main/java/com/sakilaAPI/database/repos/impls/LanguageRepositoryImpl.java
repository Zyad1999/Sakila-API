package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.Database;
import com.sakilaAPI.database.entities.Language;
import com.sakilaAPI.database.repos.interfaces.LanguageRepository;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class LanguageRepositoryImpl extends RepositoryImpl<Language> implements LanguageRepository {

    public LanguageRepositoryImpl() {
        super(Language.class);
    }

    @Override
    public Optional<Language> getLanguage(String name){
        return Database.doInTransaction(entityManager -> {
            TypedQuery<Language> query = entityManager.createQuery("SELECT e FROM Language e "+
                    "where lower(e.name) = lower(:name)", Language.class);
            query.setParameter("name",name);
            return Optional.ofNullable(query.getSingleResult());
        });
    }
}
