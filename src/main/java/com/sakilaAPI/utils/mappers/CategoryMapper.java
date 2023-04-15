package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Category;
import com.sakilaAPI.service.dtos.CategoryDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {FilmCategoryMapper.class})
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );
    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);
}