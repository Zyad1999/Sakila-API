package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.LanguageDto;
import com.sakilaAPI.service.dtos.responses.ActorResponse;
import com.sakilaAPI.service.impls.ActorServiceImpl;
import com.sakilaAPI.service.impls.LanguageServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("language")
public class Language {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LanguageDto> getAllLanguages() {
        return LanguageServiceImpl.getLanguageService().getAllLanguages();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public LanguageDto getLanguage(@PathParam("id") int id){
        return LanguageServiceImpl.getLanguageService().getLanguage(id);
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public LanguageDto getLanguage(@PathParam("name") String name){
        return LanguageServiceImpl.getLanguageService().getLanguage(name);
    }
}