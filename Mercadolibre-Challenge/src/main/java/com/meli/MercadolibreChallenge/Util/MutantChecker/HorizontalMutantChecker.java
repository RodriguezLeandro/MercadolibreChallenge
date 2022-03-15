package com.meli.MercadolibreChallenge.Util.MutantChecker;

public class HorizontalMutantChecker
{
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
