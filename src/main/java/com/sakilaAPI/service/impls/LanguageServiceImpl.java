package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Language;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.LanguageDto;
import com.sakilaAPI.service.dtos.requests.LanguageRequest;
import com.sakilaAPI.service.interfaces.LanguageService;
import com.sakilaAPI.utils.mappers.*;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LanguageServiceImpl implements LanguageService {
    private static LanguageServiceImpl languageService;

    private LanguageServiceImpl(){}

    public static LanguageService getLanguageService(){
        if(languageService == null)
            languageService = new LanguageServiceImpl();
        return languageService;
    }

    @Override
    public List<LanguageDto> getAllLanguages(int limit, int offset){
        return RepositoryFactory.getInstance().createLanguageRepository()
                .getAllEntities(limit, offset).stream()
                .map(LanguageMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public LanguageDto getLanguage(int id){
        Optional<Language> language = RepositoryFactory.getInstance().createLanguageRepository()
                .getEntityById(id);
        if(language.isPresent()){
            return LanguageMapper.INSTANCE.toDto(language.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Language not found for ID: " + id );
        }
    }

    @Override
    public LanguageDto getLanguage(String name){
        Optional<Language> language = RepositoryFactory.getInstance().createLanguageRepository()
                .getLanguage(name);
        if(language.isPresent()){
            return LanguageMapper.INSTANCE.toDto(language.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Language not found for name: " + name );
        }
    }

    @Override
    public LanguageDto addLanguage(LanguageRequest language){
        Language languageEntity = LanguageRequestMapper.INSTANCE.toEntity(language);
        languageEntity.setLastUpdate(Instant.now());
        return LanguageMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createLanguageRepository().addEntity(
                        languageEntity
                )
        );
    }

    @Override
    public void deleteLanguage(int id){
        RepositoryFactory.getInstance().createLanguageRepository().deleteEntityById(id);
    }

    @Override
    public LanguageDto updateLanguage(LanguageRequest language, int id){
        Optional<Language> languageEntity = RepositoryFactory.getInstance().createLanguageRepository()
                .getEntityById(id);
        if(languageEntity.isEmpty()){
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"language not found for ID: " + id );
        }
        LanguageRequestMapper.INSTANCE.updateEntity(language, languageEntity.get());
        return LanguageMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createLanguageRepository().updateEntity(
                        languageEntity.get()
                )
        );
    }
}
