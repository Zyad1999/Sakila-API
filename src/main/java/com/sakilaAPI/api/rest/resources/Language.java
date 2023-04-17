package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.LanguageDto;
import com.sakilaAPI.service.dtos.requests.FilmRequest;
import com.sakilaAPI.service.dtos.requests.LanguageRequest;
import com.sakilaAPI.service.dtos.responses.FilmResponse;
import com.sakilaAPI.service.impls.FilmServiceImpl;
import com.sakilaAPI.service.impls.LanguageServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("language")
public class Language {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LanguageDto> getAllLanguages(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return LanguageServiceImpl.getLanguageService().getAllLanguages(limit,offset);
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LanguageDto addLanguage(LanguageRequest language){
        return LanguageServiceImpl.getLanguageService().addLanguage(language);
    }

    @DELETE
    @Path("{id}")
    public Response deleteLanguage(@PathParam("id") int id){
        LanguageServiceImpl.getLanguageService().deleteLanguage(id);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    public LanguageDto updateLanguage(LanguageRequest language, @PathParam("id") int id){
        return LanguageServiceImpl.getLanguageService().updateLanguage(language, id);
    }
}