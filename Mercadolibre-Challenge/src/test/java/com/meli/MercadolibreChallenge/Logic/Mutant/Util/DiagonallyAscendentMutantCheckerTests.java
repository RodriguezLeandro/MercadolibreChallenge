package com.meli.MercadolibreChallenge.Logic.Mutant.Util;

import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.DiagonallyAscendentMutantChecker;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class DiagonallyAscendentMutantCheckerTests
{
    @Test
    void Test001CheckerFailsWhenDnaIsCompletelyHuman()
    {
        String[] dna = {"ABCDE", "FGHIJ", "KLMNO", "PQRST", "UVWXY"};

        boolean res = DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent(dna);

        assertFalse("Test 001 failed, dna is human but method returned true as if dna were mutant", res);
    }

    @Test
    void Test002CheckerSucceedsWhenDnaIsMutantAndFoundInFirstCharacters()
    {
        String[] dna = {"ABCAE",
                        "FGAIJ",
                        "KAMNO",
                        "AQRST",
                        "UVWXY"};

        boolean res = DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent(dna);

        assertTrue("Test 002 failed, dna is mutant but method returned false as if dna were human", res);
    }

    @Test
    void Test003CheckerSucceedsWhenDnaIsMutantAndFoundInMiddleCharacters()
    {
        String[] dna = {"123456789",
                        "AASDGQWER",
                        "TYUGOJHGF",
                        "ASGFVXZAS",
                        "FGCBNHGDE",
                        "IJKGMNOPQ",
                        "BBGBSKIOW",
                        "2G4567890",
                        "AASDFGXXY"};

        boolean res = DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent(dna);

        assertTrue("Test 003 failed, dna is mutant but method returned false as if dna were human", res);
    }

    @Test
    void Test004CheckerSucceedsWhenDnaIsMutantAndFoundInLastCharacters()
    {
        String[] dna = {
                "123456789",
                "AASDGQWER",
                "TYUGOJHGF",
                "ASWFVXZAS",
                "FGCBNHGDE",
                "IJKGMNOPT",
                "BBGBSKITW",
                "2G4567T90",
                "AASDFTXXY"};

        boolean res = DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent(dna);

        assertTrue("Test 004 failed, dna is mutant but method returned false as if dna were human", res);
    }

    @Test
    void Test005CheckerDoesNotFindAMutantWhenThereIsNotSufficientDna()
    {
        String[] dna = {"125", "214, 222"};

        boolean res = DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent(dna);

        assertFalse("Test 005 failed, not enough dna to determine mutant and method failed", res);
    }
}
