package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.Database;
import com.sakilaAPI.database.entities.Customer;
import com.sakilaAPI.database.repos.interfaces.CustomerRepository;
import jakarta.persistence.Query;

import java.time.Instant;

public class CustomerRepositoryImpl extends RepositoryImpl<Customer> implements CustomerRepository {

    public CustomerRepositoryImpl() {
        super(Customer.class);
    }

    @Override
    public Double getCustomerBalance(Integer customerId){
        return Database.doInTransaction(entityManager -> {
            Query query = entityManager.createNamedQuery("Customer.getCustomerBalance");
            query.setParameter("p_customer_id", customerId);
            query.setParameter("p_effective_date", Instant.now());
            return (double) query.getSingleResult();
        });
    }
}
