package com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util;

public class DiagonallyDescendentMutantChecker
{
    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T' in it's
     * descending center diagonal, or if descending diagonals above or below it also presents repetition.
     * */
    public static boolean isMutantDiagonallyDescendent(String[] dna)
    {
        return isMutantInDescendingDiagonalOrAbove(dna) || isMutantBelowDescendingDiagonal(dna);
    }

    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T'
     * in the center descending diagonal or above
     * */
    private static boolean isMutantInDescendingDiagonalOrAbove(String[] dna)
    {
        for(int column = dna.length-1; column > 0 ; column--)
        {
            var consecutiveMatches = 0;
            for(int row = 1; row <= column; row++)
            {
                consecutiveMatches = dna[row].charAt(dna.length-column+row-1) == dna[row-1].charAt(dna.length-column+row-2) ? consecutiveMatches+1 : 0;
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
     * below the center descending diagonal
     * */
    private static boolean isMutantBelowDescendingDiagonal(String[] dna)
    {
        for(int row = 2; row < dna.length; row++)
        {
            var consecutiveMatches = 0;
            for(int column = 0; column <= row && (column + row) < dna.length; column++)
            {
                consecutiveMatches = dna[row+column-1].charAt(column) == dna[row+column].charAt(column+1) ? consecutiveMatches+1 : 0;
                if (consecutiveMatches == 3)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
