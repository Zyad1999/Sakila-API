package com.sakilaAPI.service.dtos.requests;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddFilmToStoreRequest implements Serializable {
    private Short storeId;
    private Integer filmId;
}