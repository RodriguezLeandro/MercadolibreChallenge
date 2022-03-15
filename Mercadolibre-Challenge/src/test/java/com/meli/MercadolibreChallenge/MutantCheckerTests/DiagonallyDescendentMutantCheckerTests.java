package com.meli.MercadolibreChallenge.MutantCheckerTests;

import com.meli.MercadolibreChallenge.Util.MutantChecker.DiagonallyDescendentMutantChecker;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class DiagonallyDescendentMutantCheckerTests
{
    @Test
    void Test001CheckerFailsWhenDnaIsCompletelyHuman()
    {
        String[] dna = {"ABCDE", "FGHIJ", "KLMNO", "PQRST", "UVWXY"};

        boolean res = DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent(dna);

        assertFalse("Test 001 failed, dna is human but method returned true as if dna were mutant", res);
    }

    @Test
    void Test002CheckerSucceedsWhenDnaIsMutantAndFoundInFirstCharacters()
    {
        String[] dna = {
                "ABCAE",
                "FAAIJ",
                "KTANO",
                "GQRAT",
                "UVWXY"};

        boolean res = DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent(dna);

        assertTrue("Test 002 failed, dna is mutant but method returned false as if dna were human", res);
    }

    @Test
    void Test003CheckerSucceedsWhenDnaIsMutantAndFoundInMiddleCharacters()
    {
        String[] dna = {
                "ABCDA",
                "SGHIF",
                "JSKMS",
                "OPSRS",
                "GASSQ"
        };

        boolean res = DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent(dna);

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
                "IJKGMYOPT",
                "BBGBSKYTW",
                "2G4567TY0",
                "AASDFTXXY"};

        boolean res = DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent(dna);

        assertTrue("Test 004 failed, dna is mutant but method returned false as if dna were human", res);
    }

    @Test
    void Test005CheckerDoesNotFindAMutantWhenThereIsNotSufficientDna()
    {
        String[] dna = {"125", "214, 222"};

        boolean res = DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent(dna);

        assertFalse("Test 005 failed, not enough dna to determine mutant and method failed", res);
    }
}
