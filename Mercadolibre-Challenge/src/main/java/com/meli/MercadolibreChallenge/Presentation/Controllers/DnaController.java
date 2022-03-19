package com.meli.MercadolibreChallenge.Presentation.Controllers;

import com.meli.MercadolibreChallenge.Application.Dto.DnaDto;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.DnaLogic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class DnaController
{

    /**
     * Returns statistics of mutant/human ratio in database
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/stats")
    public ResponseEntity getDnaStatistics(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        try
        {
            var responseBody = DnaLogic.getDnaStatistics();
            return ResponseEntity.ok(responseBody);
        }catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    /**
     * Returns 403 Forbidden error when trying to get statistics via POST rest method
     * @param name
     * @param model
     * @return
     */
    @PostMapping("/stats")
    public ResponseEntity getDnaStatisticsButForbiddenRestMethod(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    /**
     * Returns 403 Forbidden error when trying to process a dna via GET rest method
     * @return
     */
    @GetMapping("/mutant")
    public ResponseEntity processDnaButForbiddenRestMethod() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    /**
     * Receives dna as parameter and analyzes if it's mutant or human dna. Then saves the information result in database
     * @param dna
     * @return
     */
    @PostMapping("/mutant")
    ResponseEntity processDna(@RequestBody DnaDto dna)
    {
        try
        {
            if (DnaLogic.isMutant(dna.getDna()))
            {
                DnaLogic.saveMutant(dna.getDna());
                return ResponseEntity.ok().build();
            }
            DnaLogic.saveHuman(dna.getDna());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }catch(Exception e)
        {
         return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
