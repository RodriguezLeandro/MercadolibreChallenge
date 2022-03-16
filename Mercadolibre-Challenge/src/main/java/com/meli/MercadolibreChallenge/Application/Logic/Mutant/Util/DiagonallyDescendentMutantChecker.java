package com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util;

public class DiagonallyDescendentMutantChecker
{
    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T' in it's
     * descending center diagonal, or if descending diagonals above or below it also presents repetition.
     * */
    public static boolean isMutantDiagonallyDescendent(String[] dna)
    {
        return isMutantInDiagonal(dna) || isMutantAboveDiagonal(dna) || isMutantBelowDiagonal(dna);
    }

    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T'
     * above the center descending diagonal
     * */
    private static boolean isMutantAboveDiagonal(String[] dna)
    {
        return isMutant(dna, dna.length-2, 0, 1);
    }

    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T'
     * in the center descending diagonal
     * */
    private static boolean isMutantInDiagonal(String[] dna)
    {
        return isMutant(dna, dna.length-1, dna.length-2, 1);
    }

    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T'
     * below the center descending diagonal
     * */
    private static boolean isMutantBelowDiagonal(String[] dna)
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

    /**
     * Processes diagonally descendent matrix traversal by using begin and end parameters as condition to cycle
     * */
    private static boolean isMutant(String[] dna, int beginColumn, int endColumn, int beginRow)
    {
        for(int column = beginColumn; column > endColumn ; column--)
        {
            var consecutiveMatches = 0;
            for(int row = beginRow; row <= column; row++)
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
}
