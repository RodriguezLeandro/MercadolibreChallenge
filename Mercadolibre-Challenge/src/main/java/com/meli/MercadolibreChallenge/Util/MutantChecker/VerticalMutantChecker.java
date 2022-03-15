package com.meli.MercadolibreChallenge.Util.MutantChecker;

public class VerticalMutantChecker
{
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
