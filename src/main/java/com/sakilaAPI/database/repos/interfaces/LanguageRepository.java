package com.sakilaAPI.database.repos.interfaces;

import com.sakilaAPI.database.entities.Language;

import java.util.Optional;

public interface LanguageRepository extends Repository<Language> {
    Optional<Language> getLanguage(String name);
}
