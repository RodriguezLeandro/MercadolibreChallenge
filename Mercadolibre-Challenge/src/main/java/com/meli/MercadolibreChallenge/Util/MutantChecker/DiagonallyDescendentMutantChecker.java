package com.meli.MercadolibreChallenge.Util.MutantChecker;

public class DiagonallyDescendentMutantChecker
{
    public static boolean isMutantDiagonallyDescendent(String[] dna)
    {
        return isMutantInDiagonal(dna) || isMutantAboveDiagonal(dna) || isMutantBelowDiagonal(dna);
    }

    private static boolean isMutantAboveDiagonal(String[] dna)
    {
        return isMutant(dna, dna.length-2, 0, 1);
    }

    private static boolean isMutantInDiagonal(String[] dna)
    {
        return isMutant(dna, dna.length-1, dna.length-2, 1);
    }

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
        /*
        for(int row = dna.length-1; row >= 0; row--)
        {
            var consecutiveMatches = 0;
            for(int column = dna.length-2; column >= 0; column--)
            {
                consecutiveMatches = dna[row].charAt(column) == dna[row+1].charAt(column+1) ? consecutiveMatches+1 : 0;
                if (consecutiveMatches == 3)
                {
                    return true;
                }
            }
        }
        */
        return false;
    }

    /*Processes diagonally descendent matrix squares by using begin and end parameters as condition to cycle*/
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
