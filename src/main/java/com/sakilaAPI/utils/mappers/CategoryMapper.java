package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Category;
import com.sakilaAPI.service.dtos.CategoryDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {FilmCategoryMapper.class})
public interface CategoryMapper {
    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category partialUpdate(CategoryDto categoryDto, @MappingTarget Category category);

    @AfterMapping
    default void linkFilmCategories(@MappingTarget Category category) {
        category.getFilmCategories().forEach(filmCategory -> filmCategory.setCategory(category));
    }
}