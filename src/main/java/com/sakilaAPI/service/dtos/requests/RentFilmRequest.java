package com.sakilaAPI.service.dtos.requests;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentFilmRequest implements Serializable {
    private Integer customerId;
    private Short staffId;
    private Integer filmId;
    private Integer storeId;
}