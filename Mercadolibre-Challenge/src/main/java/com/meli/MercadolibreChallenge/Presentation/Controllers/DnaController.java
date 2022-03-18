package com.meli.MercadolibreChallenge.Presentation.Controllers;

import com.meli.MercadolibreChallenge.Application.Dto.DnaDto;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.MutantLogic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class DnaController
{

    @GetMapping("/error")
    public ResponseEntity error() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @GetMapping("/stats")
    public ResponseEntity getDnaStatistics(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        try
        {
            var responseBody = MutantLogic.getDnaStatistics();
            return ResponseEntity.ok(responseBody);
        }catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PostMapping("/mutant")
    ResponseEntity processDna(@RequestBody DnaDto dna)
    {
        try
        {
            if (MutantLogic.isMutant(dna.getDna()))
            {
                MutantLogic.saveMutant(dna.getDna());
                return ResponseEntity.ok().build();
            }
            MutantLogic.saveHuman(dna.getDna());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }catch(Exception e)
        {
         return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
