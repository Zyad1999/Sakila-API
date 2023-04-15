package com.sakilaAPI.service.dtos.responses;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
public class BaseCategoryResponse implements Serializable {
    private final Short id;
    private final String name;
}