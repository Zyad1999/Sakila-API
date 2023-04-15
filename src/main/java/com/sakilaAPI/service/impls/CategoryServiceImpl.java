package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Category;
import com.sakilaAPI.database.entities.Rental;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.database.repos.impls.RepositoryImpl;
import com.sakilaAPI.database.repos.interfaces.Repository;
import com.sakilaAPI.service.dtos.responses.CategoryResponse;
import com.sakilaAPI.service.interfaces.CategoryService;
import com.sakilaAPI.utils.mappers.CategoryResponseMapper;
import jakarta.ws.rs.core.Response;
import org.glassfish.hk2.api.Factory;

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
    public List<CategoryResponse> getAllCategories(){
        return RepositoryFactory.getInstance().createCategoryRepository()
                .getAllEntities().stream()
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
}
