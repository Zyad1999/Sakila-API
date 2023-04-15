package com.sakilaAPI.service.dtos.responses;

import com.sakilaAPI.service.dtos.AddressDto;
import com.sakilaAPI.service.dtos.FilmDto;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
public class BaseStoreResponse implements Serializable {
    private final Short id;
    private final AddressDto address;
    private final Instant lastUpdate;
}