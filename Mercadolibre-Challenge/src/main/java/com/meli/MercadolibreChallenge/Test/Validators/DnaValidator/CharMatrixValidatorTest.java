package com.meli.MercadolibreChallenge.Test.Validators.DnaValidator;

import com.meli.MercadolibreChallenge.Application.Validators.CharMatrixValidator;
import com.meli.MercadolibreChallenge.Test.Util.TestDescriptor;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharMatrixValidatorTest
{
    @Test
    public void Test001MatrixDnaGreaterThanZeroFailsWhenNoData()
    {
        String[] dna = {};

        var validationResult = CharMatrixValidator.matrixDnaCharsGreaterThanZero(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Validator receives no data but returns true"), validationResult);
    }

    @Test
    public void Test002MatrixDnaGreaterThanZeroSucceedsWhenData()
    {
        String[] dna = {"Test"};

        var validationResult = CharMatrixValidator.matrixDnaCharsGreaterThanZero(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator receives data, but returns false"), validationResult);
    }

    @Test
    public void Test003NxNMatrixValidatorFailsWhenNullMatrix()
    {
        String[] dna = {};

        var validationResult = CharMatrixValidator.isDnaNxNMatrix(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Validator receives no data but returns true"), validationResult);
    }

    @Test
    public void Test004NxNMatrixValidatorSucceedsWhenOneElement()
    {
        String[] dna = {"data"};

        var validationResult = CharMatrixValidator.isDnaNxNMatrix(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Validator has one element but returns false"), validationResult);
    }

    @Test
    public void Test005NxMMatrixValidatorFails()
    {
        String[] dna = {"d", "te"};

        var validationResult = CharMatrixValidator.isDnaNxNMatrix(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Validator received 1x2 matrix, but returned true"), validationResult);
    }

    @Test
    public void Test006NxNMatrixValidatorSucceedes()
    {
        String[] dna = {"de", "te"};

        var validationResult = CharMatrixValidator.isDnaNxNMatrix(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator received 2x2 matrix, but returned false"), validationResult);
    }

    @Test
    public void Test007NullDnaLetterCheckSucceeds()
    {
        String[] dna = {};

        var validationResult = CharMatrixValidator.areDnaLettersOnlyFromDictionary(dna);

        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator received null dna, but returned false"), validationResult);
    }

    @Test
    public void Test007DnaHasLetterOutsideFromDiccFails()
    {
        String[] dna = {"L"};

        var validationResult = CharMatrixValidator.areDnaLettersOnlyFromDictionary(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Validator received letter not in dictionary, but returned true"), validationResult);
    }

    @Test
    public void Test008DnaHasLettersFromDiccSucceeds()
    {
        String[] dna = {"T"};
        String[] dna2 = {"A"};
        String[] dna3 = {"AAAG"};
        String[] dna4 = {"C"};
        String[] dna5 = {"GT"};
        String[] dna6 = {"ATCCCATG"};

        var validationResult1 = CharMatrixValidator.areDnaLettersOnlyFromDictionary(dna);
        var validationResult2 = CharMatrixValidator.areDnaLettersOnlyFromDictionary(dna2);
        var validationResult3 = CharMatrixValidator.areDnaLettersOnlyFromDictionary(dna3);
        var validationResult4 = CharMatrixValidator.areDnaLettersOnlyFromDictionary(dna4);
        var validationResult5 = CharMatrixValidator.areDnaLettersOnlyFromDictionary(dna5);
        var validationResult6 = CharMatrixValidator.areDnaLettersOnlyFromDictionary(dna6);

        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator received letter in dictionary, but returned false"), validationResult1);
        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator received letter in dictionary, but returned false"), validationResult2);
        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator received letter in dictionary, but returned false"), validationResult3);
        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator received letter in dictionary, but returned false"), validationResult4);
        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator received letter in dictionary, but returned false"), validationResult5);
        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator received letter in dictionary, but returned false"), validationResult6);
    }
}
