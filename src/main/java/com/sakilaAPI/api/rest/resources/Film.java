package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.CustomerDto;
import com.sakilaAPI.service.dtos.requests.CustomerRequest;
import com.sakilaAPI.service.dtos.requests.FilmRequest;
import com.sakilaAPI.service.dtos.responses.FilmResponse;
import com.sakilaAPI.service.impls.CustomerServiceImpl;
import com.sakilaAPI.service.impls.FilmServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("film")
public class Film {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FilmResponse> getAllFilms(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return FilmServiceImpl.getFilmService().getAllFilms(limit, offset);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FilmResponse getFilm(@PathParam("id") int id){
        return FilmServiceImpl.getFilmService().getFilm(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public FilmResponse addFilm(FilmRequest film){
        return FilmServiceImpl.getFilmService().addFilm(film);
    }

    @DELETE
    @Path("{id}")
    public Response deleteFilm(@PathParam("id") int id){
        FilmServiceImpl.getFilmService().deleteFilm(id);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public FilmResponse updateFilm(FilmRequest film, @PathParam("id") int id){
        return FilmServiceImpl.getFilmService().updateFilm(film, id);
    }
}