package com.example.MercadolibreChallenge.MutantCheckerTests;

import com.example.MercadolibreChallenge.Util.MutantChecker.VerticalMutantChecker;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class VerticalMutantCheckerTests
{
    @Test
    void Test001CheckerFailsWhenDnaIsCompletelyHuman()
    {
        String[] dna = {"ABCDE", "FGHIJ", "KLMNO", "PQRST", "UVWXY"};

        boolean res = VerticalMutantChecker.isMutantVertically(dna);

        assertFalse("Test 001 failed, dna is human but method returned true as if dna were mutant", res);
    }

    @Test
    void Test002CheckerSucceedsWhenDnaIsMutantAndFoundInFirstCharacters()
    {
        String[] dna = {"ABCDE", "AGHI", "AKKKL", "ANOPQ", "UVWXY"};

        boolean res = VerticalMutantChecker.isMutantVertically(dna);

        assertTrue("Test 002 failed, dna is mutant but method returned false as if dna were human", res);
    }

    @Test
    void Test003CheckerSucceedsWhenDnaIsMutantAndFoundInMiddleCharacters()
    {
        String[] dna = {"ABCDEFGH2", "IJKLMNOPQ", "BBBBMKIOW", "2345M7890", "AASDMGXXY", "1LKJ23455"};

        boolean res = VerticalMutantChecker.isMutantVertically(dna);

        assertTrue("Test 003 failed, dna is mutant but method returned false as if dna were human", res);
    }

    @Test
    void Test004CheckerSucceedsWhenDnaIsMutantAndFoundInLastCharacters()
    {
        String[] dna = {"ABCDE", "IJKPE", "BKIOE", "2789E", "FYYYE"};

        boolean res = VerticalMutantChecker.isMutantVertically(dna);

        assertTrue("Test 004 failed, dna is mutant but method returned false as if dna were human", res);
    }
}
