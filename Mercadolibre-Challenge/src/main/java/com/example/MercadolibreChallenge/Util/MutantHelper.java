package com.example.MercadolibreChallenge.Util;

import com.example.MercadolibreChallenge.Validators.DnaValidator;

public class MutantHelper
{

    public static boolean isMutant(String[] dna)
    {
        if (!DnaValidator.isValidDna(dna))
        {
            return false;
        }
        return isMutantHorizontally(dna) || isMutantVertically(dna) || isMutantDiagonallyAscendent(dna) || isMutantDiagonallyDescendent(dna);
    }

    private static boolean isMutantHorizontally(String[] dna)
    {
        var res = false;

        for(int row = 0; row < dna.length; row++)
        {
            res = res || isMutantInRow(dna[row]);
        }
        return res;
    }

    private static boolean isMutantVertically(String[] dna)
    {
        for (int col = 0; col < dna.length; col++)
        {
            var consecutiveMatches = 0;

            for(int row = 1; row < dna.length; row++)
            {
                if (consecutiveMatches == 3)
                {
                    return true;
                }
                consecutiveMatches = dna[row-1].charAt(col) == dna[row].charAt(col) ? consecutiveMatches+1 : 0;
            }
        }

        return false;
    }

    private static boolean isMutantDiagonallyAscendent(String[] dna)
    {
        var res = false;

        return isMutantDiagonallyAscendentIndexedByDiagonal(dna) || isMutantDiagonallyAscendentIndexedByFirstColumn(dna) || isMutantDiagonallyAscendentIndexedByLastRow(dna);
    }

    private static boolean isMutantDiagonallyAscendentIndexedByDiagonal(String[] dna)
    {
        /*Processes diagonal by using first column in dna matrix as index*/
        for(int row = dna.length - 1; row < dna.length; row++)
        {
            var consecutiveMatches = 0;
            for(int column = 0; column < row; column++)
            {
                if (consecutiveMatches == 3)
                {
                    return true;
                }
                consecutiveMatches = dna[row-column].charAt(column) == dna[row-column-1].charAt(column+1) ? consecutiveMatches+1 : 0;
            }
        }

        return false;
    }

    private static boolean isMutantDiagonallyAscendentIndexedByFirstColumn(String[] dna)
    {
        var consecutiveMatches = 0;

        /*Processes diagonal by using first column in dna matrix as index*/
        for(int row = 1; row < dna.length; row++)
        {
            consecutiveMatches = 0;
            for(int column = 0; column < row; column++)
            {
                consecutiveMatches = dna[row-column].charAt(column) == dna[row-column-1].charAt(column+1) ? consecutiveMatches+1 : 0;
                if (consecutiveMatches == 3)
                {
                    return true;
                }
            }
        }

        return consecutiveMatches == 3;
    }

    private static boolean isMutantDiagonallyAscendentIndexedByLastRow(String[] dna)
    {

        /*Processes diagonal by using last row in dna matrix as index*/
        /*
        for(int column = 1; column < dna.length; column++)
        {

        }
        */
        return false;
    }

    private static boolean isMutantDiagonallyDescendent(String[] dna)
    {
        return false;
    }

    private static boolean isMutantInRow(String dnaRow)
    {
        var res = false;

        var consecutiveMatches = 0;
        for (int i = 1; i < dnaRow.length(); i++)
        {
            if (consecutiveMatches == 3)
            {
                res = true;
                break;
            }
            consecutiveMatches = dnaRow.charAt(i) == dnaRow.charAt(i-1) ? consecutiveMatches+1 : 0;
        }
        return res;
    }


}
