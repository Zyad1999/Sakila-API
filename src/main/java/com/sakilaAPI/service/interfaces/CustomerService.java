package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.CustomerDto;
import com.sakilaAPI.service.dtos.responses.ActorResponse;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomer(int id);
}
