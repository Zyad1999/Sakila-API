package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.responses.FilmResponse;
import com.sakilaAPI.service.impls.FilmServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("film")
public class Film {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FilmResponse> getAllFilms() {
        return FilmServiceImpl.getFilmService().getAllFilms();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FilmResponse getFilm(@PathParam("id") int id){
        return FilmServiceImpl.getFilmService().getFilm(id);
    }
}