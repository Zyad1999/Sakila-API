package com.sakilaAPI.service.dtos;

import com.sakilaAPI.database.entities.Address;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Address} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class AddressDto implements Serializable {
    private Integer id;
    private String address;
    private String address2;
    private String district;
    private CityDto city;
    private String postalCode;
    private String phone;
    private Instant lastUpdate;
}