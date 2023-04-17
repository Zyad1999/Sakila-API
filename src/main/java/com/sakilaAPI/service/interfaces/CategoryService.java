package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.requests.CategoryRequest;
import com.sakilaAPI.service.dtos.responses.BaseCategoryResponse;
import com.sakilaAPI.service.dtos.responses.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories(int limit, int offset);

    CategoryResponse getCategory(int id);

    BaseCategoryResponse addCategory(CategoryRequest category);

    void deleteCategory(int id);

    CategoryResponse updateCategory(CategoryRequest category, int id);
}
