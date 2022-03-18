package com.meli.MercadolibreChallenge.Infrastructure;

import com.meli.MercadolibreChallenge.Domain.Entities.Dna;
import com.meli.MercadolibreChallenge.Domain.Entities.DnaHumanMutantRatio;
import com.meli.MercadolibreChallenge.Infrastructure.Repositories.DnaHumanMutantRatioRepository;
import com.meli.MercadolibreChallenge.Infrastructure.Repositories.DnaRepository;
import com.meli.MercadolibreChallenge.Test.Util.ExceptionDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Service
public class DnaService {

    private static DnaRepository dnaRepository;
    @Autowired
    public void setDnaRepository(DnaRepository dnaRepository)
    {
        DnaService.dnaRepository = dnaRepository;
    }

    private static DnaHumanMutantRatioRepository dnaHumanMutantRatioRepository;
    @Autowired
    public void setDnaHumanMutantRatioRepository(DnaHumanMutantRatioRepository humanMutantRatioRepository)
    {
        DnaService.dnaHumanMutantRatioRepository = humanMutantRatioRepository;
    }

    public static Optional<DnaHumanMutantRatio> getHumanMutantRatio()
    {
        return dnaHumanMutantRatioRepository.findById("stats");
    }

    public static void saveMutant(String[] dna)
    {
        try
        {
            var entity = createDna(dna, true);
            dnaRepository.save(entity);
        }catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(DnaService.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Exception ocurred: ", ex.getMessage()));
            throw ex;
        }
    }

    public static void saveHuman(String[] dna)
    {
        try
        {
            var entity = createDna(dna, false);
            dnaRepository.save(entity);
        }catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(DnaService.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Exception ocurred: ", ex.getMessage()));
            throw ex;
        }
    }

    public static void addMutantStat()
    {
        try
        {
            var stats = dnaHumanMutantRatioRepository.findById("stats");
            var newStats = stats.isEmpty() ? new DnaHumanMutantRatio() : stats.get();
            newStats.setMutantCount(newStats.getMutantCount()+1);
            dnaHumanMutantRatioRepository.save(newStats);
        }catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(DnaService.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Exception ocurred: ", ex.getMessage()));
            throw ex;
        }

    }
    public static void addHumanStat()
    {
        try
        {
            var stats = dnaHumanMutantRatioRepository.findById("stats");
            var newStats = stats.isEmpty() ? new DnaHumanMutantRatio() : stats.get();
            newStats.setHumanCount(newStats.getHumanCount()+1);
            dnaHumanMutantRatioRepository.save(newStats);
        }catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(DnaService.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Exception ocurred: ", ex.getMessage()));
            throw ex;
        }
    }

    private static Dna createDna(String[] dnaData, boolean isMutant)
    {
        var dna = new Dna();
        dna.setDnaID(UUID.randomUUID().toString());
        dna.setDna(Arrays.asList(dnaData));
        dna.setIsMutant(isMutant);
        return dna;
    }
}