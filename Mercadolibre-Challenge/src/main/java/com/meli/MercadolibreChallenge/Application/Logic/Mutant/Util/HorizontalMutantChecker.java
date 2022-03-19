package com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util;

public class HorizontalMutantChecker
{
    /**
     * Returns true if one row of given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T'
     * @param dna
     * @return
     */
    public static boolean isMutantHorizontally(String[] dna)
    {
        for(int row = 0; row < dna.length; row++)
        {
            var consecutiveMatches = 0;
            for (int col = 1; col < dna[row].length(); col++)
            {
                consecutiveMatches = dna[row].charAt(col) == dna[row].charAt(col-1) ? consecutiveMatches+1 : 0;
                if (consecutiveMatches == 3)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
