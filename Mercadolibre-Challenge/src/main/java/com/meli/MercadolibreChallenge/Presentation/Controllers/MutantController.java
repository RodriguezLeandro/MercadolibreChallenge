package com.meli.MercadolibreChallenge.Presentation.Controllers;

import com.meli.MercadolibreChallenge.Application.Dto.DnaDto;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.MutantLogic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MutantController
{
    @PostMapping("/mutant")
    ResponseEntity newEmployee(@RequestBody DnaDto dna) {
        try
        {
            if (MutantLogic.isMutant(dna.getDna()))
            {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }catch(Exception e)
        {
         return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
