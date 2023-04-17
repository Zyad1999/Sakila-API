package com.sakilaAPI.service.dtos.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseActorResponse implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
}