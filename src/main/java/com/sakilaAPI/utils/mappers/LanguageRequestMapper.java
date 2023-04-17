package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Language;
import com.sakilaAPI.service.dtos.requests.LanguageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LanguageRequestMapper {
    LanguageRequestMapper INSTANCE = Mappers.getMapper( LanguageRequestMapper.class );
    void updateEntity(LanguageRequest languageDto, @MappingTarget Language language);
    Language toEntity(LanguageRequest languageDto);

    LanguageRequest toDto(Language language);
}