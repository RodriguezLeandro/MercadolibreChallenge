package com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util;

public class VerticalMutantChecker
{
    /**
     * Returns true if one column of given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T'
     * @param dna
     * @return
     */
    public static boolean isMutantVertically(String[] dna)
    {
        for (int col = 0; col < dna.length; col++)
        {
            var consecutiveMatches = 0;
            for(int row = 1; row < dna.length; row++)
            {
                consecutiveMatches = dna[row-1].charAt(col) == dna[row].charAt(col) ? consecutiveMatches+1 : 0;
                if (consecutiveMatches == 3)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
