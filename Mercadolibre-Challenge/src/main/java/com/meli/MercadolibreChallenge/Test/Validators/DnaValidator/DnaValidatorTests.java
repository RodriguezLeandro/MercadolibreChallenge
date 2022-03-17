package com.meli.MercadolibreChallenge.Test.Validators.DnaValidator;

import com.meli.MercadolibreChallenge.Application.Validators.DnaValidator;
import com.meli.MercadolibreChallenge.Test.Util.TestDescriptor;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DnaValidatorTests
{
    @Test
    public void Test001ValidationFailsWhenNullDna()
    {
        String[] dna = {};

        var validationResult = DnaValidator.isValidDna(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Validator receives no data but returns true"), validationResult);
    }

    @Test
    public void Test002ValidationFailsDnaIsIncorrect()
    {
        String[] dna1 = {"asd2", "test", "123", "412", "123", "123", "asd", "afs"};
        String[] dna2 = {"gGGG", "AAA", "AGG", "GA", "AG", "GA", "G", "G"};
        String[] dna3 = {"aaaa", "AAAA", "AAAA", "AAAA", "AAAA", "AAAA", "AAAA", "AAAA"};
        String[] dna4 = {"AAAA", "GGGG", "GGAA", "TTTTG", "TGAC", "CCAG", "CCCC", "CCCA"};
        String[] dna5 = {"AAaA", "GGGG", "GGAA", "TTTT", "TGAC", "CCAG", "CCCC", "CCCA"};
        String[] dna6 = {"AAAA", "GGGG", "GGAA", "TTTT", "TGAC", "CCAG", "CCCC", "CCCB"};

        var validationResult1 = DnaValidator.isValidDna(dna1);
        var validationResult2 = DnaValidator.isValidDna(dna2);
        var validationResult3 = DnaValidator.isValidDna(dna3);
        var validationResult4 = DnaValidator.isValidDna(dna4);
        var validationResult5 = DnaValidator.isValidDna(dna5);
        var validationResult6 = DnaValidator.isValidDna(dna6);

        assertFalse(TestDescriptor.TestFailedDescription(false, "Validator receives no data but returns true"), validationResult1);
        assertFalse(TestDescriptor.TestFailedDescription(false, "Validator receives no data but returns true"), validationResult2);
        assertFalse(TestDescriptor.TestFailedDescription(false, "Validator receives no data but returns true"), validationResult3);
        assertFalse(TestDescriptor.TestFailedDescription(false, "Validator receives no data but returns true"), validationResult4);
        assertFalse(TestDescriptor.TestFailedDescription(false, "Validator receives no data but returns true"), validationResult5);
        assertFalse(TestDescriptor.TestFailedDescription(false, "Validator receives no data but returns true"), validationResult6);
    }

    @Test
    public void Test003ValidationSucceedsWhenDnaIsCorrect()
    {
        String[] dna1 = {"AAAA", "GGGG", "CCCC", "TTTT"};
        String[] dna2 = {"AAGGA", "GAGGG", "CTCCC", "CTTTT", "GGCAT"};
        String[] dna3 = {"AA", "TG"};
        String[] dna4 = {"AAATAC", "CCGGGG", "CACCCC", "CACCCC", "CACCCC", "GCTTTT"};

        var validationResult1 = DnaValidator.isValidDna(dna1);
        var validationResult2= DnaValidator.isValidDna(dna2);
        var validationResult3 = DnaValidator.isValidDna(dna3);
        var validationResult4 = DnaValidator.isValidDna(dna4);

        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator receives correct dna but returns false"), validationResult1);
        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator receives correct dna but returns false"), validationResult2);
        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator receives correct dna but returns false"), validationResult3);
        assertTrue(TestDescriptor.TestFailedDescription(true, "Validator receives correct dna but returns false"), validationResult4);
    }
}
