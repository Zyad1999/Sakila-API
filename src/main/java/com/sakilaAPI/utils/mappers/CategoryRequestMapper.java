package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Category;
import com.sakilaAPI.service.dtos.requests.CategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryRequestMapper {
    CategoryRequestMapper INSTANCE = Mappers.getMapper( CategoryRequestMapper.class );
    void updateEntity(CategoryRequest categoryDto, @MappingTarget Category category);
    Category toEntity(CategoryRequest categoryDto);

    CategoryRequest toDto(Category category);
}