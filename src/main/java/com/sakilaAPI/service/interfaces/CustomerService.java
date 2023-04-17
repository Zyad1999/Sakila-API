package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.CustomerDto;
import com.sakilaAPI.service.dtos.requests.CustomerRequest;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers(int limit, int offset);

    CustomerDto getCustomer(int id);

    CustomerDto addCustomer(CustomerRequest customer);

    void deleteCustomer(int id);

    CustomerDto updateCustomer(CustomerRequest customer, int id);
}
