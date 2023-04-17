package com.sakilaAPI.service.dtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.sakilaAPI.database.entities.Customer} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class CustomerDto implements Serializable {
    private Integer id;
    private StoreDto store;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;
    private Boolean active;
    private Instant createDate;
    private Instant lastUpdate;
}