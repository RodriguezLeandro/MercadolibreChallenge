package com.meli.MercadolibreChallenge.Application.Validators;

import com.meli.MercadolibreChallenge.Application.Validators.DnaValidator.DnaValidator;
import com.meli.MercadolibreChallenge.Application.Validators.DnaValidator.IDnaValidator;

public interface ValidatorFactory
{
    /**
     * returns an instance of dnaValidator
     * */
    static IDnaValidator CreateDnaValidator() {
        return new DnaValidator();
    }
}
