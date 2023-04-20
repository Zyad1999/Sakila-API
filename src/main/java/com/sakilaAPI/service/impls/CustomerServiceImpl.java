package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Customer;
import com.sakilaAPI.database.entities.Inventory;
import com.sakilaAPI.database.entities.Rental;
import com.sakilaAPI.database.entities.Staff;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.database.repos.interfaces.Repository;
import com.sakilaAPI.database.repos.interfaces.StoreRepository;
import com.sakilaAPI.service.dtos.RentalDto;
import com.sakilaAPI.service.dtos.requests.CustomerRequest;
import com.sakilaAPI.service.dtos.requests.RentFilmRequest;
import com.sakilaAPI.service.dtos.responses.CustomerResponse;
import com.sakilaAPI.service.interfaces.CustomerService;
import com.sakilaAPI.utils.mappers.CustomerRequestMapper;
import com.sakilaAPI.utils.mappers.CustomerResponseMapper;
import com.sakilaAPI.utils.mappers.RentalMapper;
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
    public List<CustomerResponse> getAllCustomers(int limit, int offset){
        return RepositoryFactory.getInstance().createCustomerRepository()
                .getAllEntities(limit, offset).stream()
                .map(CustomerResponseMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerResponse getCustomer(int id){
        Optional<Customer> customer = RepositoryFactory.getInstance().createCustomerRepository()
                .getEntityById(id);
        if(customer.isPresent()){
            return CustomerResponseMapper.INSTANCE.toDto(customer.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Customer not found for ID: " + id );
        }
    }

    @Override
    public CustomerResponse addCustomer(CustomerRequest customer){
        Customer customerEntity = CustomerRequestMapper.INSTANCE.toEntity(customer);
        customerEntity.setLastUpdate(Instant.now());
        customerEntity.setActive(true);
        customerEntity.setCreateDate(Instant.now());
        return CustomerResponseMapper.INSTANCE.toDto(
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
    public CustomerResponse updateCustomer(CustomerRequest customer, int id){
        Optional<Customer> customerEntity = RepositoryFactory.getInstance().createCustomerRepository()
                .getEntityById(id);
        if(customerEntity.isEmpty()){
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"customer not found for ID: " + id );
        }
        CustomerRequestMapper.INSTANCE.updateEntity(customer, customerEntity.get());
        return CustomerResponseMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createCustomerRepository().updateEntity(
                        customerEntity.get()
                )
        );
    }

    @Override
    public RentalDto rentFilm(RentFilmRequest request){
        StoreRepository storeRepository = RepositoryFactory.getInstance().createStoreRepository();
        if(storeRepository.filmInStock(request.getFilmId(), request.getStoreId()) <= 0){
            throw new BusinessException(Response.Status.NOT_MODIFIED.getReasonPhrase(),
                    Response.Status.NOT_MODIFIED.getStatusCode()
                    ,"Film with id: " + request.getFilmId() + "Not available at store with id "+request.getStoreId() );
        }

        for(Inventory inventory : storeRepository
                .getFilmInventories(request.getFilmId(), request.getStoreId())){
            if(storeRepository.inventoryInStock(inventory.getId())){
                return RentalMapper.INSTANCE
                        .toDto(RepositoryFactory.getInstance().createRepository(Rental.class)
                        .addEntity(Rental.builder()
                                .rentalDate(Instant.now())
                                .inventory(inventory)
                                .customer(Customer.builder().id(request.getCustomerId()).build())
                                .staff(Staff.builder().id(request.getStaffId()).build())
                                .lastUpdate(Instant.now())
                                .build()));
            }
        }
        return null;
    }

    @Override
    public RentalDto returnFilm(Integer rentalId){
        Repository<Rental> rentalRepository = RepositoryFactory.getInstance().createRepository(Rental.class);
        Optional<Rental> rentalEntity = rentalRepository.getEntityById(rentalId);
        if(rentalEntity.isPresent()){
            rentalEntity.get().setReturnDate(Instant.now());
            rentalRepository.updateEntity(rentalEntity.get());
            return RentalMapper.INSTANCE.toDto(rentalEntity.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Rental not found for ID: " + rentalId );
        }
    }

}
