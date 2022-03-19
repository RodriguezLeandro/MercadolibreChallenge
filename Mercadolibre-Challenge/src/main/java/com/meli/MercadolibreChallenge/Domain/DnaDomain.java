package com.meli.MercadolibreChallenge.Domain;

import com.meli.MercadolibreChallenge.Domain.Entities.Dna;
import com.meli.MercadolibreChallenge.Infrastructure.Repositories.DnaRepository;
import com.meli.MercadolibreChallenge.Test.Util.ExceptionDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
public class DnaDomain {

    private static DnaRepository dnaRepository;
    @Autowired
    public void setDnaRepository(DnaRepository dnaRepository)
    {
        DnaDomain.dnaRepository = dnaRepository;
    }

    /**
     * Returns all the dnas stored in database
     * @return
     */
    public static Iterable<Dna> getDnas()
    {
        return dnaRepository.findAll();
    }

    /**
     * Saves mutant dna in database
     * @param dna
     */
    public static void saveMutant(String[] dna)
    {
        try
        {
            var entity = createDna(dna, true);
            dnaRepository.save(entity);
        }catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(DnaDomain.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Exception ocurred: ", ex.getMessage()));
            throw ex;
        }
    }

    /**
     * Saves human dna in database
     * @param dna
     */
    public static void saveHuman(String[] dna)
    {
        try
        {
            var entity = createDna(dna, false);
            dnaRepository.save(entity);
        }catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(DnaDomain.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Exception ocurred: ", ex.getMessage()));
            throw ex;
        }
    }

    /**
     * Given dna data and if it's human or mutant, creates dna entity
     * @param dnaData
     * @param isMutant
     * @return
     */
    private static Dna createDna(String[] dnaData, boolean isMutant)
    {
        var dna = new Dna();
        dna.setDnaID(UUID.randomUUID().toString());
        dna.setDna(Arrays.asList(dnaData));
        dna.setIsMutant(isMutant);
        return dna;
    }
}