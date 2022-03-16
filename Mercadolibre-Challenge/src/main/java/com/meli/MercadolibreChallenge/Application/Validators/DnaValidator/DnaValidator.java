package com.meli.MercadolibreChallenge.Application.Validators.DnaValidator;

public class DnaValidator implements IDnaValidator
{
    public DnaValidator(){ };

    /**
     * Returns true if given dna is has at least one character,
     * is a square matrix, and all it's elements are ASCII chars: 'A','C','G' or 'T'
     * */
    public boolean isValidDna(String[] dna)
    {
        return this.matrixDnaCharsGreaterThanZero(dna) && this.isDnaNxNMatrix(dna) && this.areDnaLettersOnlyFromDictionary(dna);
    }

    /**
     * Returns true if given dna is has at least one character,
     * */
    private boolean matrixDnaCharsGreaterThanZero(String[] dna)
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
     * */
    private boolean isDnaNxNMatrix(String[] dna)
    {
        for(int i = 0; i < dna.length; i++)
        {
            if (dna[i].length() != dna.length)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if all given dna elements are ASCII chars: 'A','C','G' or 'T'
     * */
    private boolean areDnaLettersOnlyFromDictionary(String[] dna)
    {
        for(int i = 0; i < dna.length; i++)
        {
            if (dna[i].length() != dna.length)
            {
                return false;
            }
        }
        return true;
    }

}
