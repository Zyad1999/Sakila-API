package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.entities.Category;
import com.sakilaAPI.database.entities.Film;
import com.sakilaAPI.database.repos.interfaces.CategoryRepository;
import com.sakilaAPI.database.repos.interfaces.FilmRepository;

public class CategoryRepositoryImpl extends RepositoryImpl<Category> implements CategoryRepository {

    public CategoryRepositoryImpl() {
        super(Category.class);
    }
}
