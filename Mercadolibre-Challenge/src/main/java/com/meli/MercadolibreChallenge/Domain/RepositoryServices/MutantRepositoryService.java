package com.meli.MercadolibreChallenge.Domain.RepositoryServices;

import com.meli.MercadolibreChallenge.Domain.Entities.Customer;
import com.meli.MercadolibreChallenge.Infrastructure.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantRepositoryService {

    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(final Customer customer) {
        customerRepository.save(customer);
    }
}