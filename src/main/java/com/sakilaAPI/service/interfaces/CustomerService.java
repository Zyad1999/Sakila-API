package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.requests.CustomerRequest;
import com.sakilaAPI.service.dtos.responses.CustomerResponse;

import java.util.List;

public interface CustomerService {
    List<CustomerResponse> getAllCustomers(int limit, int offset);

    CustomerResponse getCustomer(int id);

    CustomerResponse addCustomer(CustomerRequest customer);

    void deleteCustomer(int id);

    CustomerResponse updateCustomer(CustomerRequest customer, int id);
}
