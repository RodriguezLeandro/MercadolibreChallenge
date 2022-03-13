package com.example.MercadolibreChallenge.Controllers;

import com.example.MercadolibreChallenge.Dto.DnaDto;
import com.example.MercadolibreChallenge.Util.MutantHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MutantController
{
    @PostMapping("/mutant")
    ResponseEntity newEmployee(@RequestBody DnaDto dna) {
        if (MutantHelper.isMutant(dna.getDna()))
        {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
