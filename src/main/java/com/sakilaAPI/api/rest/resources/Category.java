package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.responses.CategoryResponse;
import com.sakilaAPI.service.impls.CategoryServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("category")
public class Category {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryResponse> getAllCategories() {
        return CategoryServiceImpl.getCategoryService().getAllCategories();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryResponse getCategory(@PathParam("id") int id){
        return CategoryServiceImpl.getCategoryService().getCategory(id);
    }
}