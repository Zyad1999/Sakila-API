package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.requests.FilmRequest;
import com.sakilaAPI.service.dtos.responses.FilmResponse;

import java.util.List;

public interface FilmService {
    List<FilmResponse> getAllFilms(int limit, int offset);

    FilmResponse getFilm(int id);

    FilmResponse addFilm(FilmRequest film);

    void deleteFilm(int id);

    FilmResponse updateFilm(FilmRequest film, int id);
}
