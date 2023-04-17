package com.sakilaAPI.service.dtos.requests;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@XmlRootElement
@NoArgsConstructor
public class StoreRequest implements Serializable {
    private Integer addressId;
    private Short managerId;
}