package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.responses.ActorResponse;
import com.sakilaAPI.service.dtos.responses.FilmResponse;

import java.util.List;

public interface FilmService {
    List<FilmResponse> getAllFilms();

    FilmResponse getFilm(int id);
}
