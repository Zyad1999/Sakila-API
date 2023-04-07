package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.entities.Film;
import com.sakilaAPI.database.repos.interfaces.FilmRepository;

public class FilmRepositoryImpl extends RepositoryImpl<Film> implements FilmRepository {

    public FilmRepositoryImpl() {
        super(Film.class);
    }
}
