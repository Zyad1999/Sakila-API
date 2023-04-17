package com.sakilaAPI.api.soap.services;

import com.sakilaAPI.service.dtos.LanguageDto;
import com.sakilaAPI.service.dtos.requests.LanguageRequest;
import com.sakilaAPI.service.impls.LanguageServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

@WebService
public class Language {

    @WebMethod
    public List<LanguageDto> getAllLanguages(@WebParam(name = "limit") int limit, @WebParam(name = "offset") int offset) {
        return LanguageServiceImpl.getLanguageService().getAllLanguages(limit,offset);
    }

    @WebMethod
    public LanguageDto getLanguage(@WebParam(name = "id") int id){
        return LanguageServiceImpl.getLanguageService().getLanguage(id);
    }

    @WebMethod
    public LanguageDto getLanguageByName(@WebParam(name = "name") String name){
        return LanguageServiceImpl.getLanguageService().getLanguage(name);
    }

    @WebMethod
    public LanguageDto addLanguage(LanguageRequest language){
        return LanguageServiceImpl.getLanguageService().addLanguage(language);
    }

    @WebMethod
    public void deleteLanguage(@WebParam(name = "id") int id){
        LanguageServiceImpl.getLanguageService().deleteLanguage(id);
    }

    @WebMethod
    public LanguageDto updateLanguage(LanguageRequest language, @WebParam(name = "id") int id){
        return LanguageServiceImpl.getLanguageService().updateLanguage(language, id);
    }
}
