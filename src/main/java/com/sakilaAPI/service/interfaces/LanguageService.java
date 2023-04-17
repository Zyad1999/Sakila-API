package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.LanguageDto;
import com.sakilaAPI.service.dtos.requests.LanguageRequest;

import java.util.List;

public interface LanguageService {
    List<LanguageDto> getAllLanguages(int limit, int offset);

    LanguageDto getLanguage(int id);

    LanguageDto getLanguage(String name);

    LanguageDto addLanguage(LanguageRequest language);

    void deleteLanguage(int id);

    LanguageDto updateLanguage(LanguageRequest language, int id);
}
