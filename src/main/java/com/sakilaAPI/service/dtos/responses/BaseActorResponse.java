package com.sakilaAPI.service.dtos.responses;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class BaseActorResponse implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
}