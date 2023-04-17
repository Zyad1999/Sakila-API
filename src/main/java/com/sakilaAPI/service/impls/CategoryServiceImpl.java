package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Category;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.requests.CategoryRequest;
import com.sakilaAPI.service.dtos.responses.BaseCategoryResponse;
import com.sakilaAPI.service.dtos.responses.CategoryResponse;
import com.sakilaAPI.service.interfaces.CategoryService;
import com.sakilaAPI.utils.mappers.*;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {
    private static CategoryServiceImpl categoryService;

    private CategoryServiceImpl(){}

    public static CategoryService getCategoryService(){
        if(categoryService == null)
            categoryService = new CategoryServiceImpl();
        return categoryService;
    }

    @Override
    public List<CategoryResponse> getAllCategories(int limit, int offset){
        return RepositoryFactory.getInstance().createCategoryRepository()
                .getAllEntities(limit, offset).stream()
                .map(CategoryResponseMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getCategory(int id){
        Optional<Category> category = RepositoryFactory.getInstance().createCategoryRepository()
                .getEntityById(id);
        if(category.isPresent()){
            return CategoryResponseMapper.INSTANCE.toDto(category.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Category not found for ID: " + id );
        }
    }

    @Override
    public BaseCategoryResponse addCategory(CategoryRequest category){
        Category categoryEntity = CategoryRequestMapper.INSTANCE.toEntity(category);
        categoryEntity.setLastUpdate(Instant.now());
        return BaseCategoryResponseMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createCategoryRepository().addEntity(
                        categoryEntity
                )
        );
    }

    @Override
    public void deleteCategory(int id){
        RepositoryFactory.getInstance().createCategoryRepository().deleteEntityById(id);
    }

    @Override
    public CategoryResponse updateCategory(CategoryRequest category, int id){
        Optional<Category> categoryEntity = RepositoryFactory.getInstance().createCategoryRepository()
                .getEntityById(id);
        if(categoryEntity.isEmpty()){
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"category not found for ID: " + id );
        }
        CategoryRequestMapper.INSTANCE.updateEntity(category, categoryEntity.get());
        return CategoryResponseMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createCategoryRepository().updateEntity(
                        categoryEntity.get()
                )
        );
    }
}
