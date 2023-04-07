package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Rental} entity
 */
@Data
public class RentalDto implements Serializable {
    private final Integer id;
    private final Instant rentalDate;
    private final InventoryDto inventory;
    private final CustomerDto customer;
    private final Instant returnDate;
    private final StaffDto staff;
    private final Instant lastUpdate;
}