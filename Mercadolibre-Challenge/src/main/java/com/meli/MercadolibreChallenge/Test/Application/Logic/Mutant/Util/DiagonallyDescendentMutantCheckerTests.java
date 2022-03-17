package com.meli.MercadolibreChallenge.Test.Application.Logic.Mutant.Util;

import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.DiagonallyAscendentMutantChecker;
import com.meli.MercadolibreChallenge.Application.Logic.Mutant.Util.DiagonallyDescendentMutantChecker;
import com.meli.MercadolibreChallenge.Test.Util.TestDescriptor;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class DiagonallyDescendentMutantCheckerTests
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

        boolean res = DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Test failed, dna is human but method returned true"), res);
    }

    @Test
    public void Test003CheckerSucceedsWhenDnaIsMutantAndFoundInFirstCharacters()
    {
        String[] dna = {
                "ABCAE",
                "FAAIJ",
                "KTANO",
                "GQRAT",
                "UVWXY"};

        boolean res = DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true, "Test failed, dna is mutant but method returned false"), res);
    }

    @Test
    public void Test004CheckerSucceedsWhenDnaIsMutantAndFoundInMiddleCharacters()
    {
        String[] dna = {
                "ABCDA",
                "SGHIF",
                "JSKMS",
                "OPSRS",
                "GASSQ"
        };

        boolean res = DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true, "Test failed, dna is mutant but method returned false"), res);
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
                "IJKGMYOPT",
                "BBGBSKYTW",
                "2G4567TY0",
                "AASDFTXXY"};

        boolean res = DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res);
    }

    @Test
    public void Test006CheckerDoesNotFindAMutantWhenThereIsNotSufficientDna()
    {
        String[] dna = {"125", "214, 222"};

        boolean res = DiagonallyDescendentMutantChecker.isMutantDiagonallyDescendent(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Test failed, not enough dna to determine mutant and method returned true"), res);
    }
}
