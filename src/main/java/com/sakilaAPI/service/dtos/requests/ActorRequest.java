package com.sakilaAPI.service.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActorRequest implements Serializable {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}