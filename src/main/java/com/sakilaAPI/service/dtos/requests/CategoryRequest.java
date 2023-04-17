package com.sakilaAPI.service.dtos.requests;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryRequest implements Serializable {
    private String name;
}