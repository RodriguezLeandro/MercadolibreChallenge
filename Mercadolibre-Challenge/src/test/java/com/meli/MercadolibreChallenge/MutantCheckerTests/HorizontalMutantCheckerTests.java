package com.meli.MercadolibreChallenge.MutantCheckerTests;

import com.meli.MercadolibreChallenge.Util.MutantChecker.HorizontalMutantChecker;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class HorizontalMutantCheckerTests
{
    @Test
    void Test001CheckerFailsWhenDnaIsCompletelyHuman()
    {
        String[] dna = {"ABCDE", "FGHIJ", "KLMNO", "PQRST", "UVWXY"};

        boolean res = HorizontalMutantChecker.isMutantHorizontally(dna);

        assertFalse("Test 001 failed, dna is human but method returned true as if dna were mutant", res);
    }

    @Test
    void Test002CheckerSucceedsWhenDnaIsMutantAndFoundInFirstCharacters()
    {
        String[] dna = {"ABCDE", "FGHI", "KKKKL", "MNOPQ", "UVWXY"};

        boolean res = HorizontalMutantChecker.isMutantHorizontally(dna);

        assertTrue("Test 002 failed, dna is mutant but method returned false as if dna were human", res);
    }

    @Test
    void Test003CheckerSucceedsWhenDnaIsMutantAndFoundInMiddleCharacters()
    {
        String[] dna = {"ABCDEFGH2", "IJKLMNOPQ", "BBBBSKIOW", "234567890", "AASDFGXXY"};

        boolean res = HorizontalMutantChecker.isMutantHorizontally(dna);

        assertTrue("Test 003 failed, dna is mutant but method returned false as if dna were human", res);
    }

    @Test
    void Test004CheckerSucceedsWhenDnaIsMutantAndFoundInLastCharacters()
    {
        String[] dna = {"ABCDE", "IJKPQ", "BKIOW", "27890", "FYYYY"};

        boolean res = HorizontalMutantChecker.isMutantHorizontally(dna);

        assertTrue("Test 004 failed, dna is mutant but method returned false as if dna were human", res);
    }

    @Test
    void Test005CheckerDoesNotFindAMutantWhenThereIsNotSufficientDna()
    {
        String[] dna = {"125", "214, 222"};

        boolean res = HorizontalMutantChecker.isMutantHorizontally(dna);

        assertFalse("Test 005 failed, not enough dna to determine mutant and method failed", res);
    }
}
