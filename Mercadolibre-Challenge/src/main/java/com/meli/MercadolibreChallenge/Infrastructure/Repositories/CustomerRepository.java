package com.meli.MercadolibreChallenge.Infrastructure.Repositories;

import com.meli.MercadolibreChallenge.Domain.Entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CustomerRepository extends CrudRepository<Customer, String>
{
    Optional<Customer> findById(String id);
}
