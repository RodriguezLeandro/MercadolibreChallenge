package com.meli.MercadolibreChallenge.Infrastructure.Repositories;

import com.meli.MercadolibreChallenge.Domain.Entities.Dna;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface DnaRepository extends CrudRepository<Dna, String>
{
}
