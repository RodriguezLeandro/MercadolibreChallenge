package com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util;

public class DiagonallyAscendentMutantChecker
{
    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T' in it's
     * ascending center diagonal, or if ascending diagonals above or below it also presents repetition.
     * @param dna
     * @return
     */
    public static boolean isMutantDiagonallyAscendent(String[] dna)
    {
        return isMutantInAscendingDiagonalOrAbove(dna) || isMutantBelowAscendingDiagonal(dna);
    }

    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T'
     * in or above the center ascending diagonal
     * @param dna
     * @return
     */
    private static boolean isMutantInAscendingDiagonalOrAbove(String[] dna)
    {
        for(int row = 1; row < dna.length; row++)
        {
            var consecutiveMatches = 0;
            for(int column = 0; column < row; column++)
            {
                consecutiveMatches = dna[row-column].charAt(column) == dna[row-column-1].charAt(column+1) ? consecutiveMatches+1 : 0;
                if (consecutiveMatches == 3)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T'
     * below the center ascending diagonal
     * @param dna
     * @return
     */

    private static boolean isMutantBelowAscendingDiagonal(String[] dna)
    {
        for(int column = dna.length-1; column > 0 ; column--)
        {
            var consecutiveMatches = 0;
            for(int row = dna.length-1; row >= column; row--)
            {
                consecutiveMatches = dna[row].charAt(column-1 + (dna.length-1-row)) == dna[row-1].charAt(column + (dna.length-1-row)) ? consecutiveMatches+1 : 0;
                if (consecutiveMatches == 3)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
