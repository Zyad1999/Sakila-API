package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.LanguageDto;
import com.sakilaAPI.service.dtos.responses.ActorResponse;

import java.util.List;

public interface LanguageService {
    List<LanguageDto> getAllLanguages();

    LanguageDto getLanguage(int id);

    LanguageDto getLanguage(String name);
}
