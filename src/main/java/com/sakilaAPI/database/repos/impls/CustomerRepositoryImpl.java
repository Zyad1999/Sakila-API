package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.entities.Category;
import com.sakilaAPI.database.entities.Customer;
import com.sakilaAPI.database.repos.interfaces.CategoryRepository;
import com.sakilaAPI.database.repos.interfaces.CustomerRepository;

public class CustomerRepositoryImpl extends RepositoryImpl<Customer> implements CustomerRepository {

    public CustomerRepositoryImpl() {
        super(Customer.class);
    }
}
