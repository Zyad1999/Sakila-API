package com.sakilaAPI.utils.mappers;

import com.sakilaAPI.database.entities.Language;
import com.sakilaAPI.service.dtos.LanguageDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageMapper {
    LanguageMapper INSTANCE = Mappers.getMapper( LanguageMapper.class );
    Language toEntity(LanguageDto languageDto);

    LanguageDto toDto(Language language);
}