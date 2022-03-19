package com.meli.MercadolibreChallenge.Application.Validators;

import java.util.HashMap;

public class CharMatrixValidator
{
    static final private HashMap<Character, Boolean> ValidAscii;

    static
    {
        ValidAscii = new HashMap<Character, Boolean>();
        ValidAscii.put('A', true);
        ValidAscii.put('C', true);
        ValidAscii.put('G', true);
        ValidAscii.put('T', true);
    }

    /**
     * Returns true if given dna is has at least one character,
     * @param dna
     * @return
     */
    public static boolean matrixDnaCharsGreaterThanZero(String[] dna)
    {
        for(int i = 0; i < dna.length; i++)
        {
            if (dna[i].length() > 0)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if given dna is a square matrix
     * @param dna
     * @return
     */
    public static  boolean isDnaNxNMatrix(String[] dna)
    {
        for(int i = 0; i < dna.length; i++)
        {
            if (dna[i].length() != dna.length)
            {
                return false;
            }
        }
        return dna.length > 0;
    }

    /**
     * Returns true if all given dna elements are ASCII chars: 'A','C','G' or 'T'
     * @param dna
     * @return
     */
    public static  boolean areDnaLettersOnlyFromDictionary(String[] dna)
    {
        for(int row = 0; row < dna.length; row++)
        {
            for(int column = 0; column < dna.length; column++)
            {
                if (!ValidAscii.containsKey(dna[row].charAt(column)))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
