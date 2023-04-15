package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.responses.ActorResponse;
import com.sakilaAPI.service.dtos.responses.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();

    CategoryResponse getCategory(int id);
}
