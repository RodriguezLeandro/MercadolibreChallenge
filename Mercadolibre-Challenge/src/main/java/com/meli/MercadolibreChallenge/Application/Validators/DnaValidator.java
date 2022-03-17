package com.meli.MercadolibreChallenge.Application.Validators;

public class DnaValidator
{
    /**
     * Returns true if given dna is has at least one character,
     * is a square matrix, and all it's elements are ASCII chars: 'A','C','G' or 'T'
     * */
    public static boolean isValidDna(String[] dna)
    {
        return CharMatrixValidator.matrixDnaCharsGreaterThanZero(dna) && CharMatrixValidator.isDnaNxNMatrix(dna) && CharMatrixValidator.areDnaLettersOnlyFromDictionary(dna);
    }
}
