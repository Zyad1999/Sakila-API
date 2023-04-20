package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.config.exceptions.BusinessExceptions;
import com.sakilaAPI.database.entities.*;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.requests.FilmRequest;
import com.sakilaAPI.service.dtos.responses.FilmResponse;
import com.sakilaAPI.service.interfaces.FilmService;
import com.sakilaAPI.utils.mappers.FilmRequestMapper;
import com.sakilaAPI.utils.mappers.FilmResponseMapper;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
import java.util.*;
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
    public List<FilmResponse> getAllFilms(int limit, int offset){
        return RepositoryFactory.getInstance().createFilmRepository()
                .getAllEntities(limit, offset).stream()
                .map(FilmResponseMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public FilmResponse getFilm(int id){
        Optional<Film> film = RepositoryFactory.getInstance().createFilmRepository()
                .getEntityById(id);
        if(film.isPresent()){
            return FilmResponseMapper.INSTANCE.toDto(film.get());
        }else {
            throw new BusinessException(BusinessExceptions.NOT_FOUND.getPhrase(),
                    BusinessExceptions.NOT_FOUND.getCode()
                    ,"Film not found for ID: " + id );
        }
    }

    @Override
    public FilmResponse addFilm(FilmRequest film){
        Film filmEntity = FilmRequestMapper.INSTANCE.toEntity(film);
        addActorsToFilm(filmEntity,film.getFilmActorsIds());
        addCategoriesToFilm(filmEntity, film.getFilmCategoriesIds());
        filmEntity.setLastUpdate(Instant.now());
        return FilmResponseMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createFilmRepository().addEntity(
                        filmEntity
                )
        );
    }

    @Override
    public void deleteFilm(int id){
        RepositoryFactory.getInstance().createFilmRepository().deleteEntityById(id);
    }

    private void addActorsToFilm(Film film, Set<Integer> actorsIds){
        try {
            Set<FilmActor> filmActors = new LinkedHashSet<>();
            for(Integer actorId:actorsIds){
                filmActors.add(FilmActor.builder()
                        .film(film)
                        .actor(RepositoryFactory.getInstance().createActorRepository().getEntityById(actorId).get())
                        .id(new FilmActorId())
                        .lastUpdate(Instant.now())
                        .build()
                );
            }
            film.setFilmActors(filmActors);
        }catch(NoSuchElementException e){
            throw new BusinessException(BusinessExceptions.BAD_REQUEST.getPhrase(),
                    BusinessExceptions.BAD_REQUEST.getCode()
                    ,"Invalid actor ID In the actors list");
        }
    }

    private void addCategoriesToFilm(Film film, Set<Short> categoriesIds){
        try {
            Set<FilmCategory> filmCategories = new LinkedHashSet<>();
            for(Short categoryId:categoriesIds){
                filmCategories.add(FilmCategory.builder()
                        .film(film)
                        .category(RepositoryFactory.getInstance().createCategoryRepository().getEntityById(categoryId.intValue()).get())
                        .id(new FilmCategoryId())
                        .lastUpdate(Instant.now())
                        .build()
                );
            }
            film.setFilmCategories(filmCategories);
        }catch(NoSuchElementException e){
            throw new BusinessException(BusinessExceptions.BAD_REQUEST.getPhrase(),
                    BusinessExceptions.BAD_REQUEST.getCode()
                    ,"Invalid category ID In the actors list");
        }
    }

    @Override
    public FilmResponse updateFilm(FilmRequest film, int id){
        Optional<Film> filmEntity = RepositoryFactory.getInstance().createFilmRepository()
                .getEntityById(id);
        if(filmEntity.isEmpty()){
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"film not found for ID: " + id );
        }
        FilmRequestMapper.INSTANCE.updateEntity(film, filmEntity.get());
        return FilmResponseMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createFilmRepository().updateEntity(
                        filmEntity.get()
                )
        );
    }
}
