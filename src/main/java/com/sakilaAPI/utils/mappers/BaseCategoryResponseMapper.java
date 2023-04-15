package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Category;
import com.sakilaAPI.service.dtos.responses.BaseCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaseCategoryResponseMapper {
    BaseCategoryResponseMapper INSTANCE = Mappers.getMapper( BaseCategoryResponseMapper.class );
    Category toEntity(BaseCategoryResponse categoryDto);

    BaseCategoryResponse toDto(Category category);
}