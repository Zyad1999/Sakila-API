package com.sakilaAPI.api.rest.resources;

import com.sakilaAPI.service.dtos.AddressDto;
import com.sakilaAPI.service.dtos.requests.AddressRequest;
import com.sakilaAPI.service.dtos.requests.CategoryRequest;
import com.sakilaAPI.service.dtos.responses.BaseCategoryResponse;
import com.sakilaAPI.service.dtos.responses.CategoryResponse;
import com.sakilaAPI.service.impls.AddressServiceImpl;
import com.sakilaAPI.service.impls.CategoryServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("category")
public class Category {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryResponse> getAllCategories(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return CategoryServiceImpl.getCategoryService().getAllCategories(limit, offset);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryResponse getCategory(@PathParam("id") int id){
        return CategoryServiceImpl.getCategoryService().getCategory(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BaseCategoryResponse addCategory(CategoryRequest category){
        return CategoryServiceImpl.getCategoryService().addCategory(category);
    }

    @DELETE
    @Path("{id}")
    public Response deleteCategory(@PathParam("id") int id){
        CategoryServiceImpl.getCategoryService().deleteCategory(id);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CategoryResponse updateCategory(CategoryRequest category, @PathParam("id") int id){
        return CategoryServiceImpl.getCategoryService().updateCategory(category, id);
    }
}