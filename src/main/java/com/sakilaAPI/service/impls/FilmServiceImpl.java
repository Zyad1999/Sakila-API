package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Film;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.responses.FilmResponse;
import com.sakilaAPI.service.interfaces.FilmService;
import com.sakilaAPI.utils.mappers.FilmResponseMapper;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilmServiceImpl implements FilmService {
    private static FilmServiceImpl filmService;

    private FilmServiceImpl(){}

    public static FilmService getFilmService(){
        if(filmService == null)
            filmService = new FilmServiceImpl();
        return filmService;
    }

    @Override
    public List<FilmResponse> getAllFilms(){
        return RepositoryFactory.getInstance().createFilmRepository()
                .getAllEntities().stream()
                .map(FilmResponseMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public FilmResponse getFilm(int id){
        Optional<Film> film = RepositoryFactory.getInstance().createFilmRepository()
                .getEntityById(id);
        if(film.isPresent()){
            return FilmResponseMapper.INSTANCE.toDto(film.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Film not found for ID: " + id );
        }
    }
}
