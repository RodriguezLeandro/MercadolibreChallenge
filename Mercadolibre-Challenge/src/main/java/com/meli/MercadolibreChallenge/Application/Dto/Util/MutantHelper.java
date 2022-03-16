package com.meli.MercadolibreChallenge.Application.Dto.Util;

import com.meli.MercadolibreChallenge.Application.Dto.Util.MutantChecker.DiagonallyDescendentMutantChecker;
import com.meli.MercadolibreChallenge.Application.Dto.Util.MutantChecker.HorizontalMutantChecker;
import com.meli.MercadolibreChallenge.Application.Dto.Validators.DnaValidator;

import static com.meli.MercadolibreChallenge.Application.Dto.Util.MutantChecker.DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent;
import static com.meli.MercadolibreChallenge.Application.Dto.Util.MutantChecker.VerticalMutantChecker.isMutantVertically;

public class MutantHelper
{

    public static boolean isMutant(String[] dna)
    {
        try
        {
            if (!DnaValidator.isValidDna(dna))
            {
                return false;
            }
            return HorizontalMutantChecker.isMutantHorizontally(dna) || isMutantVertically(dna) || isMutantDiagonallyAscendent(dna) || DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent(dna);
        }catch(Exception e)
        {
            throw e;
        }
    }
}
