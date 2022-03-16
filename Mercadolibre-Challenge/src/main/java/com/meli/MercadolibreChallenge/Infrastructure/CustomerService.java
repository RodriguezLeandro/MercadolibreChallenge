package com.meli.MercadolibreChallenge.Infrastructure;

import com.meli.MercadolibreChallenge.Domain.Entities.Customer;
import com.meli.MercadolibreChallenge.Infrastructure.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(final Customer customer) {
        customerRepository.save(customer);
    }
}