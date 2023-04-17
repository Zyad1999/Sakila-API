package com.sakilaAPI.api.soap.services;

import com.sakilaAPI.service.dtos.requests.CategoryRequest;
import com.sakilaAPI.service.dtos.responses.BaseCategoryResponse;
import com.sakilaAPI.service.dtos.responses.CategoryResponse;
import com.sakilaAPI.service.impls.CategoryServiceImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.QueryParam;


import java.util.List;

@WebService
public class Category {

    @WebMethod
    public List<CategoryResponse> getAllCategories(@WebParam(name = "limit") int limit, @QueryParam("offset") int offset) {
        return CategoryServiceImpl.getCategoryService().getAllCategories(limit, offset);
    }

    @WebMethod
    public CategoryResponse getCategory(@WebParam(name = "id") int id){
        return CategoryServiceImpl.getCategoryService().getCategory(id);
    }

    @WebMethod
    public BaseCategoryResponse addCategory(CategoryRequest category){
        return CategoryServiceImpl.getCategoryService().addCategory(category);
    }

    @WebMethod
    public void deleteCategory(@WebParam(name = "id") int id){
        CategoryServiceImpl.getCategoryService().deleteCategory(id);
    }

    @WebMethod
    public CategoryResponse updateCategory(CategoryRequest category, @WebParam(name = "id") int id){
        return CategoryServiceImpl.getCategoryService().updateCategory(category, id);
    }
}
