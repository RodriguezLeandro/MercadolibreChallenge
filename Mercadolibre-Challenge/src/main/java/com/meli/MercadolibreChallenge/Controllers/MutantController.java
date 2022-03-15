package com.meli.MercadolibreChallenge.Controllers;

import com.meli.MercadolibreChallenge.Dto.DnaDto;
import com.meli.MercadolibreChallenge.Util.MutantHelper;
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
            if (MutantHelper.isMutant(dna.getDna()))
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
