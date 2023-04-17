package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Customer;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.CustomerDto;
import com.sakilaAPI.service.dtos.requests.CustomerRequest;
import com.sakilaAPI.service.interfaces.CustomerService;
import com.sakilaAPI.utils.mappers.CustomerRequestMapper;
import com.sakilaAPI.utils.mappers.CustomerMapper;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    private static CustomerServiceImpl customerService;

    private CustomerServiceImpl(){}

    public static CustomerService getCustomerService(){
        if(customerService == null)
            customerService = new CustomerServiceImpl();
        return customerService;
    }

    @Override
    public List<CustomerDto> getAllCustomers(int limit, int offset){
        return RepositoryFactory.getInstance().createCustomerRepository()
                .getAllEntities(limit, offset).stream()
                .map(CustomerMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomer(int id){
        Optional<Customer> customer = RepositoryFactory.getInstance().createCustomerRepository()
                .getEntityById(id);
        if(customer.isPresent()){
            return CustomerMapper.INSTANCE.toDto(customer.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Customer not found for ID: " + id );
        }
    }

    @Override
    public CustomerDto addCustomer(CustomerRequest customer){
        Customer customerEntity = CustomerRequestMapper.INSTANCE.toEntity(customer);
        customerEntity.setLastUpdate(Instant.now());
        customerEntity.setActive(true);
        customerEntity.setCreateDate(Instant.now());
        return CustomerMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createCustomerRepository().addEntity(
                        customerEntity
                )
        );
    }

    @Override
    public void deleteCustomer(int id){
        RepositoryFactory.getInstance().createCustomerRepository().deleteEntityById(id);
    }

    @Override
    public CustomerDto updateCustomer(CustomerRequest customer, int id){
        Optional<Customer> customerEntity = RepositoryFactory.getInstance().createCustomerRepository()
                .getEntityById(id);
        if(customerEntity.isEmpty()){
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"customer not found for ID: " + id );
        }
        CustomerRequestMapper.INSTANCE.updateEntity(customer, customerEntity.get());
        return CustomerMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createCustomerRepository().updateEntity(
                        customerEntity.get()
                )
        );
    }
}
