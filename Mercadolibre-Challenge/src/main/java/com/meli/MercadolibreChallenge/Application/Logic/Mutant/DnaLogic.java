package com.meli.MercadolibreChallenge.Application.Logic.Mutant;

import com.meli.MercadolibreChallenge.Application.Dto.DnaHumanMutantRatioDto;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.DiagonallyAscendentMutantChecker;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.DiagonallyDescendentMutantChecker;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.HorizontalMutantChecker;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.VerticalMutantChecker;
import com.meli.MercadolibreChallenge.Application.Validators.DnaValidator;
import com.meli.MercadolibreChallenge.Domain.DnaDomain;
import com.meli.MercadolibreChallenge.Test.Util.ExceptionDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DnaLogic
{

    private static DnaDomain dnaDomain;

    @Autowired
    public void setDnaService(DnaDomain dnaService)
    {
        DnaLogic.dnaDomain = dnaService;
    }

    /**
     * Returns statistics of mutant/human ratio information stored in database
     * @return
     */
    public static DnaHumanMutantRatioDto getDnaStatistics()
    {
        try
        {
            var dnaIterator = DnaDomain.getDnas().iterator();

            var mutantCount = 0;
            var humanCount = 0;

            while(dnaIterator.hasNext())
            {
                if(dnaIterator.next().getIsMutant())
                {
                    mutantCount++;
                }
                else
                {
                    humanCount++;
                }
            }
            return CreateDnaHumanMutantRatioDto(mutantCount, humanCount);
        }catch(Exception ex)
        {
            throw ex;
        }
    }

    /**
     * Returns true if given dna is human, or false in case of dna being mutant.
     * @param dna
     * @return
     */
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
            Logger logger = LoggerFactory.getLogger(DnaLogic.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Arithmetic exception ocurred: ", ex.getMessage()));
            throw ex;
        }
    }

    /**
     * Saves mutant dna in database
     * @param dna
     */
    public static void saveMutant(String[] dna)
    {
        try
        {
            DnaDomain.saveMutant(dna);
        }catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(DnaLogic.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Arithmetic exception ocurred: ", ex.getMessage()));
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
            DnaDomain.saveHuman(dna);
        }catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(DnaLogic.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Arithmetic exception ocurred: ", ex.getMessage()));
            throw ex;
        }
    }

    /**
     * Given mutant and human counts, returns dto with the mutant/human ratio
     * @param mutant_count
     * @param human_count
     * @return
     */
    private static DnaHumanMutantRatioDto CreateDnaHumanMutantRatioDto(int mutant_count, int human_count)
    {
        var res = new DnaHumanMutantRatioDto();

        res.setcount_mutant_dna(mutant_count);
        res.setcount_human_dna(human_count);
        res.setratio(CalculateHumanMutantRatio(mutant_count, human_count));

        return res;
    }

    /**
     * Calculates mutant to human ratio by doing the operation mutantsQuantity/humansQuantity.
     * In case of humansQuantity being 0, returns 0 as the ratio
     * */
    private static float CalculateHumanMutantRatio(int mutant_count, int human_count)
    {
        var res = 0.0f;
        try
        {
            res = human_count > 0 ? (float)mutant_count / (float)human_count : 0.0f;
        }catch(ArithmeticException ex)
        {
            Logger logger = LoggerFactory.getLogger(DnaLogic.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Arithmetic exception ocurred: ", ex.getMessage()));
            throw ex;
        }
        catch(Exception ex)
        {
            Logger logger = LoggerFactory.getLogger(DnaLogic.class);
            logger.error(ExceptionDescriptor.ExceptionOcurred("Exception ocurred: ", ex.getMessage()));
            throw ex;
        }
        return res;
    }
}

