package com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util;

public class DiagonallyAscendentMutantChecker
{
    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T' in it's
     * ascending center diagonal, or if ascending diagonals above or below it also presents repetition.
     * */
    public static boolean isMutantDiagonallyAscendent(String[] dna)
    {
        return isMutantInDiagonal(dna) || isMutantAboveDiagonal(dna) || isMutantBelowDiagonal(dna);
    }

    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T'
     * in the center ascending diagonal
     * */
    private static boolean isMutantInDiagonal(String[] dna)
    {
        return isMutant(dna, dna.length-1, dna.length, 0);
    }

    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T'
     * above the center ascending diagonal
     * */
    private static boolean isMutantAboveDiagonal(String[] dna)
    {
        return isMutant(dna, 1, dna.length-1, 0);
    }

    /**
     * Returns true if given dna has 4 consecutive repeated ASCII chars: 'A','C','G' or 'T'
     * below the center ascending diagonal
     * */
    private static boolean isMutantBelowDiagonal(String[] dna)
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

    /**
     * Processes diagonally ascendent matrix traversal by using begin and end parameters as condition to cycle
     * */    private static boolean isMutant(String[] dna, int beginRow, int endRow, int beginColumn)
    {
        for(int row = beginRow; row < endRow; row++)
        {
            var consecutiveMatches = 0;
            for(int column = beginColumn; column < row; column++)
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
}
