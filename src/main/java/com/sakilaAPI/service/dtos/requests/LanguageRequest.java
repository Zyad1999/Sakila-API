package com.sakilaAPI.service.dtos.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class LanguageRequest implements Serializable {
    private String name;
}