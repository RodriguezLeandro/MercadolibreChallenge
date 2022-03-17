package com.meli.MercadolibreChallenge.Test.Application.Logic.Mutant.Util;

import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.DiagonallyAscendentMutantChecker;
import com.meli.MercadolibreChallenge.Test.Util.TestDescriptor;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class DiagonallyAscendentMutantCheckerTests
{
    @Test
    public void Test001CheckerFailsWhenDnaHasOneElement()
    {
        String[] dna = {"A"};

        boolean res = DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false,"Test failed, dna is human but method returned true"), res);
    }

    @Test
    public void Test002CheckerFailsWhenDnaIsCompletelyHuman()
    {
        String[] dna = {"ABCDE", "FGHIJ", "KLMNO", "PQRST", "UVWXY"};

        boolean res = DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false,"Test failed, dna is human but method returned true"), res);
    }

    @Test
    public void Test003CheckerSucceedsWhenDnaIsMutantAndFoundInFirstCharacters()
    {
        String[] dna = {"ABCAE",
                        "FGAIJ",
                        "KAMNO",
                        "AQRST",
                        "UVWXY"};

        boolean res = DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true, "Test failed, dna is mutant but method returned false"), res);
    }

    @Test
    public  void Test004CheckerSucceedsWhenDnaIsMutantAndFoundInMiddleCharacters()
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

        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res);
    }

    @Test
    public void Test005CheckerSucceedsWhenDnaIsMutantAndFoundInLastCharacters()
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

        assertTrue(TestDescriptor.TestFailedDescription(true, "Test failed, dna is mutant but method returned false"), res);
    }

    @Test
    public void Test006CheckerDoesNotFindAMutantWhenThereIsNotSufficientDna()
    {
        String[] dna = {"125", "214, 222"};

        boolean res = DiagonallyAscendentMutantChecker.isMutantDiagonallyAscendent(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Test failed, not enough dna to determine mutant and method returned true"), res);
    }
}
