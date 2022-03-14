package com.example.MercadolibreChallenge.Util;

import com.example.MercadolibreChallenge.Validators.DnaValidator;

import static com.example.MercadolibreChallenge.Util.MutantChecker.DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent;
import static com.example.MercadolibreChallenge.Util.MutantChecker.DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent;
import static com.example.MercadolibreChallenge.Util.MutantChecker.HorizontalMutantChecker.isMutantHorizontally;
import static com.example.MercadolibreChallenge.Util.MutantChecker.VerticalMutantChecker.isMutantVertically;

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
            return isMutantHorizontally(dna) || isMutantVertically(dna) || isMutantDiagonallyAscendent(dna) || isMutantDiagonallyDescendent(dna);
        }catch(Exception e)
        {
            throw e;
        }
    }
}
