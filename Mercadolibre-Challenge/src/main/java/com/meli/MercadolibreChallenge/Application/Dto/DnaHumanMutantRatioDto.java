package com.meli.MercadolibreChallenge.Application.Dto;

public class DnaHumanMutantRatioDto
{
    private int count_human_dna;
    private int count_mutant_dna;
    private float ratio;

    public int getcount_mutant_dna()
    {
        return this.count_mutant_dna;
    }

    public int getcount_human_dna()
    {
        return this.count_human_dna;
    }

    public float getratio()
    {
        return this.ratio;
    }

    public void setcount_human_dna(int humanQuantity)
    {
        this.count_human_dna = humanQuantity;
    }
    public void setcount_mutant_dna(int mutantQuantity)
    {
        this.count_mutant_dna = mutantQuantity;
    }
    public void setratio(float mutantToHumanRatio)
    {
        this.ratio = mutantToHumanRatio;
    }
}
