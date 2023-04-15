package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.database.entities.Customer;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.CustomerDto;
import com.sakilaAPI.service.dtos.StoreDto;
import com.sakilaAPI.service.dtos.responses.ActorResponse;
import com.sakilaAPI.service.interfaces.ActorService;
import com.sakilaAPI.service.interfaces.CustomerService;
import com.sakilaAPI.utils.mappers.ActorResponseMapper;
import com.sakilaAPI.utils.mappers.CustomerMapper;
import com.sakilaAPI.utils.mappers.StoreMapper;
import jakarta.ws.rs.core.Response;

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
    public List<CustomerDto> getAllCustomers(){
        return RepositoryFactory.getInstance().createCustomerRepository()
                .getAllEntities().stream()
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
}
