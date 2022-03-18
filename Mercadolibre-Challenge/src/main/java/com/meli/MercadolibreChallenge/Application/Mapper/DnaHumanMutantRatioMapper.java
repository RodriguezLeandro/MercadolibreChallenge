package com.meli.MercadolibreChallenge.Application.Mapper;

import com.meli.MercadolibreChallenge.Application.Dto.DnaHumanMutantRatioDto;
import com.meli.MercadolibreChallenge.Domain.Entities.DnaHumanMutantRatio;

public class DnaHumanMutantRatioMapper
{
    public static DnaHumanMutantRatioDto toDto(DnaHumanMutantRatio dnaHumanMutantRatio)
    {
        var res = new DnaHumanMutantRatioDto();

        res.setcount_human_dna(dnaHumanMutantRatio.getHumanCount());
        res.setcount_mutant_dna(dnaHumanMutantRatio.getMutantCount());

        return res;
    }
}
