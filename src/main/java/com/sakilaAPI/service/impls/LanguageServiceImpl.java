package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Film;
import com.sakilaAPI.database.entities.Language;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.LanguageDto;
import com.sakilaAPI.service.dtos.responses.FilmResponse;
import com.sakilaAPI.service.interfaces.FilmService;
import com.sakilaAPI.service.interfaces.LanguageService;
import com.sakilaAPI.utils.mappers.FilmResponseMapper;
import com.sakilaAPI.utils.mappers.LanguageMapper;
import jakarta.ws.rs.core.Response;

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
    public List<LanguageDto> getAllLanguages(){
        return RepositoryFactory.getInstance().createLanguageRepository()
                .getAllEntities().stream()
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
}
