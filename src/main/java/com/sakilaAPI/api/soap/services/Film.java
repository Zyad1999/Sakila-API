package com.sakilaAPI.api.soap.services;

import com.sakilaAPI.service.dtos.requests.FilmRequest;
import com.sakilaAPI.service.dtos.responses.FilmResponse;
import com.sakilaAPI.service.impls.FilmServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

@WebService
public class Film {

    @WebMethod
    public List<FilmResponse> getAllFilms(@WebParam(name = "limit") int limit, @WebParam(name = "offset") int offset) {
        return FilmServiceImpl.getFilmService().getAllFilms(limit, offset);
    }

    @WebMethod
    public FilmResponse getFilm(@WebParam(name = "id") int id){
        return FilmServiceImpl.getFilmService().getFilm(id);
    }

    @WebMethod
    public FilmResponse addFilm(FilmRequest film){
        return FilmServiceImpl.getFilmService().addFilm(film);
    }

    @WebMethod
    public void deleteFilm(@WebParam(name = "id") int id){
        FilmServiceImpl.getFilmService().deleteFilm(id);
    }

    @WebMethod
    public FilmResponse updateFilm(FilmRequest film, @WebParam(name = "id") int id){
        return FilmServiceImpl.getFilmService().updateFilm(film, id);
    }
}
