package com.meli.MercadolibreChallenge.Test.Application.Logic.Mutant.Util;

import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.HorizontalMutantChecker;
import com.meli.MercadolibreChallenge.Test.Util.TestDescriptor;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class HorizontalMutantCheckerTests
{
    @Test
    public void Test001CheckerFailsWhenDnaHasOneElement()
    {
        String[] dna = {"A"};

        boolean res = HorizontalMutantChecker.isMutantHorizontally(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false,"Test failed, dna is human but method returned true"), res);
    }

    @Test
    public void Test002CheckerFailsWhenDnaIsCompletelyHuman()
    {
        String[] dna = {"ABCDE", "FGHIJ", "KLMNO", "PQRST", "UVWXY"};

        boolean res = HorizontalMutantChecker.isMutantHorizontally(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Test failed, dna is human but method returned true"), res);
    }

    @Test
    public void Test003CheckerSucceedsWhenDnaIsMutantAndFoundInFirstCharacters()
    {
        String[] dna = {"ABCDE", "FGHI", "KKKKL", "MNOPQ", "UVWXY"};

        boolean res = HorizontalMutantChecker.isMutantHorizontally(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true, "Test failed, dna is mutant but method returned false"), res);
    }

    @Test
    public void Test004CheckerSucceedsWhenDnaIsMutantAndFoundInMiddleCharacters()
    {
        String[] dna = {"ABCDEFGH2", "IJKLMNOPQ", "BBBBSKIOW", "234567890", "AASDFGXXY"};

        boolean res = HorizontalMutantChecker.isMutantHorizontally(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res);
    }

    @Test
    public void Test005CheckerSucceedsWhenDnaIsMutantAndFoundInLastCharacters()
    {
        String[] dna = {"ABCDE", "IJKPQ", "BKIOW", "27890", "FYYYY"};

        boolean res = HorizontalMutantChecker.isMutantHorizontally(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res);
    }

    @Test
    public void Test006CheckerDoesNotFindAMutantWhenThereIsNotSufficientDna()
    {
        String[] dna = {"125", "214, 222"};

        boolean res = HorizontalMutantChecker.isMutantHorizontally(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Test failed, not enough dna to determine mutant but method returned true"), res);
    }
}
