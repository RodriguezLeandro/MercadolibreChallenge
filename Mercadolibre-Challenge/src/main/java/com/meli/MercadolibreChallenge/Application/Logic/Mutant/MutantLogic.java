package com.meli.MercadolibreChallenge.Application.Logic.Mutant;

import com.meli.MercadolibreChallenge.Application.Dto.DnaHumanMutantRatioDto;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.DiagonallyAscendentMutantChecker;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.DiagonallyDescendentMutantChecker;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.HorizontalMutantChecker;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.VerticalMutantChecker;
import com.meli.MercadolibreChallenge.Application.Mapper.DnaHumanMutantRatioMapper;
import com.meli.MercadolibreChallenge.Application.Validators.DnaValidator;
import com.meli.MercadolibreChallenge.Infrastructure.DnaService;
import com.meli.MercadolibreChallenge.Test.Util.ExceptionDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutantLogic
{

    private static DnaService dnaService;

    @Autowired
    public void setDnaService(DnaService dnaService)
    {
        MutantLogic.dnaService = dnaService;
    }

    /**
     * Returns true if given dna contains a sequence of 4 repeated ASCII chars: 'A','C','G' or 'T'.
     * */
    public static DnaHumanMutantRatioDto getHumanMutantRatio()
    {
        try
        {
            var dnaHumanMutantRatio = dnaService.getHumanMutantRatio();
            var dnaHumanMutantRatioDto = dnaHumanMutantRatio.isEmpty() ? new DnaHumanMutantRatioDto() : DnaHumanMutantRatioMapper.toDto(dnaHumanMutantRatio.get()) ;
            return CalculateHumanMutantRatio(dnaHumanMutantRatioDto);
        }catch(Exception ex)
        {
            throw ex;
        }
    }

    /**
     * Returns true if given dna contains a sequence of 4 repeated ASCII chars: 'A','C','G' or 'T'.
     * */
    public static boolean isMutant(String[] dna)
    {
        try
        {
            if (!DnaValidator.isValidDna(dna))
            {
                return false;
            }
            return HorizontalMutantChecker.isMutantHorizontally(dna) ||
                    VerticalMutantChecker.isMutantVertically(dna) ||
                    DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent(dna) ||
                    DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent(dna);
        }catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(MutantLogic.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Arithmetic exception ocurred: ", ex.getMessage()));
            throw ex;
        }
    }

    public static void saveMutant(String[] dna)
    {
        try
        {
            dnaService.saveMutant(dna);
            dnaService.addMutantStat();
        }catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(MutantLogic.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Arithmetic exception ocurred: ", ex.getMessage()));
            throw ex;
        }
    }

    public static void saveHuman(String[] dna)
    {
        try
        {
            dnaService.saveHuman(dna);
            dnaService.addHumanStat();
        }catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(MutantLogic.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Arithmetic exception ocurred: ", ex.getMessage()));
            throw ex;
        }
    }

    /**
     * Calculates mutant to human ratio by doing the operation mutantsQuantity divided by humansQuantity
     * */
    private static DnaHumanMutantRatioDto CalculateHumanMutantRatio(DnaHumanMutantRatioDto dnaHumanMutantRatioDto)
    {
        try
        {
            dnaHumanMutantRatioDto.setratio((float)dnaHumanMutantRatioDto.getcount_mutant_dna() / (float)dnaHumanMutantRatioDto.getcount_human_dna());
        }catch(ArithmeticException ex)
        {
            Logger logger = LoggerFactory.getLogger(MutantLogic.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Arithmetic exception ocurred: ", ex.getMessage()));
            throw ex;
        }
        catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(MutantLogic.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Exception ocurred: ", ex.getMessage()));
            throw ex;
        }
        return dnaHumanMutantRatioDto;
    }
}

