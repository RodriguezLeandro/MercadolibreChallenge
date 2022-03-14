package com.example.MercadolibreChallenge.Validators;

public class DnaValidator
{
    public static boolean isValidDna(String[] dna)
    {
        /*TODO: Validate letters are those from dictionary, validate square matrix, validate matrix not null*/
        if (dna.length == 0)
        {
            return false;
        }
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
