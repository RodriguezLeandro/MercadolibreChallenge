package com.meli.MercadolibreChallenge.Util;

import com.meli.MercadolibreChallenge.Validators.DnaValidator;
import com.meli.MercadolibreChallenge.Util.MutantChecker.HorizontalMutantChecker;

import static com.meli.MercadolibreChallenge.Util.MutantChecker.DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent;
import static com.meli.MercadolibreChallenge.Util.MutantChecker.DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent;
import static com.meli.MercadolibreChallenge.Util.MutantChecker.VerticalMutantChecker.isMutantVertically;

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
            return HorizontalMutantChecker.isMutantHorizontally(dna) || isMutantVertically(dna) || isMutantDiagonallyAscendent(dna) || isMutantDiagonallyDescendent(dna);
        }catch(Exception e)
        {
            throw e;
        }
    }
}
