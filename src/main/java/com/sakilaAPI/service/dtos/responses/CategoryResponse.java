package com.sakilaAPI.service.dtos.responses;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class CategoryResponse implements Serializable {
    private Short id;
    private String name;
    private Set<BaseFilmResponse> films;
}