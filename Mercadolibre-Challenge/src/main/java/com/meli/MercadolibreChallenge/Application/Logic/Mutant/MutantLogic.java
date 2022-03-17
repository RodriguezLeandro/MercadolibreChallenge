package com.meli.MercadolibreChallenge.Application.Logic.Mutant;

import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.DiagonallyAscendentMutantChecker;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.DiagonallyDescendentMutantChecker;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.HorizontalMutantChecker;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.VerticalMutantChecker;
import com.meli.MercadolibreChallenge.Application.Validators.DnaValidator;

public class MutantLogic
{
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
        }catch(Exception e)
        {
            throw e;
        }
    }
}
