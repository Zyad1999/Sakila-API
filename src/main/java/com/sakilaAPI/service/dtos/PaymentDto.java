package com.sakilaAPI.service.dtos;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Payment} entity
 */
@Data
public class PaymentDto implements Serializable {
    private final Integer id;
    private final CustomerDto customer;
    private final StaffDto staff;
    private final RentalDto rental;
    private final BigDecimal amount;
    private final Instant paymentDate;
    private final Instant lastUpdate;
}