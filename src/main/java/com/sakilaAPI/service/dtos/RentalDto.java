package com.sakilaAPI.service.dtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Rental} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class RentalDto implements Serializable {
    private Integer id;
    private Instant rentalDate;
    private InventoryDto inventory;
    private CustomerDto customer;
    private Instant returnDate;
    private StaffDto staff;
    private Instant lastUpdate;
}