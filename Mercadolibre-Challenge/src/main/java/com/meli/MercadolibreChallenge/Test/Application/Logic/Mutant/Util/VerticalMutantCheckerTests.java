package com.meli.MercadolibreChallenge.Test.Application.Logic.Mutant.Util;

import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.VerticalMutantChecker;
import com.meli.MercadolibreChallenge.Test.Util.TestDescriptor;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class VerticalMutantCheckerTests
{
    @Test
    public void Test001CheckerFailsWhenDnaHasOneElement()
    {
        String[] dna = {"A"};

        boolean res = VerticalMutantChecker.isMutantVertically(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false,"Test failed, dna is human but method returned true"), res);
    }

    @Test
    public void Test002CheckerFailsWhenDnaIsCompletelyHuman()
    {
        String[] dna = {"ABCDE", "FGHIJ", "KLMNO", "PQRST", "UVWXY"};

        boolean res = VerticalMutantChecker.isMutantVertically(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false,"Test failed, dna is human but method returned true"), res);
    }

    @Test
    public void Test003CheckerSucceedsWhenDnaIsMutantAndFoundInFirstCharacters()
    {
        String[] dna = {"ABCDE", "AGHI", "AKKKL", "ANOPQ", "UVWXY"};

        boolean res = VerticalMutantChecker.isMutantVertically(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true, "Test failed, dna is mutant but method returned false"), res);
    }

    @Test
    public void Test004CheckerSucceedsWhenDnaIsMutantAndFoundInMiddleCharacters()
    {
        String[] dna = {"ABCDEFGH2", "IJKLMNOPQ", "BBBBMKIOW", "2345M7890", "AASDMGXXY", "1LKJ23455"};

        boolean res = VerticalMutantChecker.isMutantVertically(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true, "Test failed, dna is mutant but method returned false"), res);
    }

    @Test
    public void Test005CheckerSucceedsWhenDnaIsMutantAndFoundInLastCharacters()
    {
        String[] dna = {"ABCDE", "IJKPE", "BKIOE", "2789E", "FYYYE"};

        boolean res = VerticalMutantChecker.isMutantVertically(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true, "Test failed, dna is mutant but method returned false"), res);
    }

    @Test
    public void Test006CheckerDoesNotFindAMutantWhenThereIsNotSufficientDna()
    {
        String[] dna = {"125", "214, 222"};

        boolean res = VerticalMutantChecker.isMutantVertically(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Test failed, not enough dna to determine mutant and method returned true"), res);
    }
}
