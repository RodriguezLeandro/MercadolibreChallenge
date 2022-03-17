package com.meli.MercadolibreChallenge.Test.Application.Logic.Mutant;

import com.meli.MercadolibreChallenge.Application.Logic.Mutant.MutantLogic;
import com.meli.MercadolibreChallenge.Test.Util.TestDescriptor;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class MutantLogicTests
{
    @Test
    public void Test001ValidationFailsWhenDnaIsNull()
    {
        String[] dna = {};

        boolean res = MutantLogic.isMutant(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false,"Test failed, dna is human but method returned true"), res);
    }

    @Test
    public void Test002ValidationFailsWhenDnaHasOneElement()
    {
        String[] dna = {"A"};

        boolean res = MutantLogic.isMutant(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false,"Test failed, dna is human but method returned true"), res);
    }

    @Test
    public void Test003ValidationFailsWhenDnaHasOnlyHumans()
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

        boolean res = MutantLogic.isMutant(dna);

        assertFalse(TestDescriptor.TestFailedDescription(false,"Test failed, dna is fully human but method returned true"), res);
    }

    @Test
    public void Test004ValidationSucceedsWhenDnaHasMutant()
    {

        /*Mutants Horizontally*/
        String[] dna1 = {
                "AAGGTTACC",
                "ACGTAAAGG",
                "CCTATCTGG",
                "ACTGACAGT",
                "TGAGTATCG",
                "CGATACGTA",
                "TGCGCAAAA",
                "GATCTACTA",
                "ACAGTACAC"};

        String[] dna2 = {
                "AAGGTTACC",
                "ACGTAAAGG",
                "CCTATCTGG",
                "ACTGACAGT",
                "TGAGTATCG",
                "CGATACGTA",
                "TGCGCACGA",
                "GATCTACTA",
                "ACAGTCCCC"};

        String[] dna3 = {
                "GGGGTTACC",
                "ACGTAAAGG",
                "CCTATCTGG",
                "ACTGACAGT",
                "TGAGTATCG",
                "CGATACGTA",
                "TGCGCAAAA",
                "GATCTACTA",
                "ACAGTACAC"};

        String[] dna4 = {
                "AAGGTTACC",
                "ACGTAAAGG",
                "CCTATCTGG",
                "ACTGACAGT",
                "TGAGTATCG",
                "CGATACGTA",
                "TGCGCAAAA",
                "GATCTACTA",
                "CCCCTACAC"};

        String[] dna5 = {
                "AAGGCTTTT",
                "ACGTAAAGG",
                "CCTATCTGG",
                "ACTGACAGT",
                "TGAGTATCG",
                "CGATACGTA",
                "TGCGCAAAA",
                "GATCTACTA",
                "GCCCTACAC"};

        String[] dna6 = {
                "AAGGCTTCT",
                "ACGTAAAGG",
                "CCTATCTGG",
                "ACCCCCAGT",
                "TGAGTATCG",
                "CGATACGTA",
                "TGCGCAAAA",
                "GATCTACTA",
                "GCCCTACAC"};

        /*Mutants Vertically*/
        String[] dna7 = {
                "AAGGTTACC",
                "ACGTAAAGG",
                "ACTATCTGG",
                "ACTGACAGT",
                "TGAGTATCG",
                "CGATACGTA",
                "TGCGCAACA",
                "GATCTACTA",
                "ACAGTACAC"};

        String[] dna8 = {
                "AAGGTTACG",
                "CCGTAAAGG",
                "ACTATCTGG",
                "ACTGACAGG",
                "TGAGTATCG",
                "CGATACGTA",
                "TGCGCAACA",
                "GATCTACTA",
                "ACAGTACAC"};

        String[] dna9 = {
                "AAGGTTACG",
                "CCGTAAAGC",
                "ACTATCTGG",
                "ACTGACAGG",
                "TGAGTATCG",
                "CGATACGTA",
                "CGCGCAACA",
                "CATCTACTA",
                "CCAGTACAC"};

        String[] dna10 = {
                "AAGGTTACG",
                "CCGTAAAGC",
                "ACTATCTGG",
                "ACTGACAGG",
                "TGAGTATCG",
                "CGATACGTT",
                "CGCGCAACT",
                "TATCTACTT",
                "CCAGTACAT"};

        String[] dna11 = {
                "AAGGTTACG",
                "CCGTAAACC",
                "ACTATCTCG",
                "ACTGACACG",
                "TGAGTATCG",
                "CGATACGTT",
                "CGCGCAACT",
                "TATCTACTC",
                "CCAGTACAT"};

        /*Mutants Diagonally Ascendent*/
        String[] dna12 = {
                "AAGGTTACC",
                "ACGTAAAGG",
                "CCTATCTGG",
                "ACTGACAGT",
                "TGAGTATCG",
                "CGAAACGTA",
                "TGAGCACAA",
                "GATCTACTA",
                "ACAGTACAC"};

        String[] dna13 = {
                "AAGATTACC",
                "ACATAAAGG",
                "CATATCTGG",
                "ACTGACAGT",
                "TGAGTATCG",
                "CGATACGTA",
                "TGAGCACAA",
                "GATCTACTA",
                "ACAGTACAC"};
        String[] dna14 = {
                "AAGGTTACC",
                "ACGTAAAGG",
                "CCTATCTGG",
                "ACTGACAGT",
                "TGAGTATCG",
                "CGATCCGTA",
                "TGACCACAA",
                "GACCTACTA",
                "ACAGTACAC"};
        String[] dna15 = {
                "AAGGTTACC",
                "ACGTAAAGG",
                "CCTATCTGG",
                "ACTGACAGT",
                "TGAGTATCG",
                "CGATACGTG",
                "TGAGCACGA",
                "GATCTAGTA",
                "ACAGTGCAC"};

        /*Mutants Diagonally Descendent*/

        String[] dna16 = {
                "AAGGTTACC",
                "AAGTAAAGG",
                "CCAATCTGG",
                "ACTAACAGT",
                "TGAGTATCG",
                "CGATACGTA",
                "TGAGCACAA",
                "GATCTACTA",
                "ACAGTACAC"};

        String[] dna17 = {
                "AAGGTTACC",
                "ACGTAAAGG",
                "CCTATCTGG",
                "ACTGACAGT",
                "TGCGTATCG",
                "CGACACGTA",
                "TGAGCACAA",
                "GATCTACTA",
                "ACAGTACAC"};

        String[] dna18 = {
                "AAGGTTACC",
                "ACGTATAGG",
                "CCTATCTGG",
                "ACTGACATT",
                "TGAGTATCG",
                "CGATACGTA",
                "TGAGCACAA",
                "GATCTACTA",
                "ACAGTACAC"};

        boolean res1 = MutantLogic.isMutant(dna1);
        boolean res2 = MutantLogic.isMutant(dna2);
        boolean res3 = MutantLogic.isMutant(dna3);
        boolean res4 = MutantLogic.isMutant(dna4);
        boolean res5 = MutantLogic.isMutant(dna5);
        boolean res6 = MutantLogic.isMutant(dna6);
        boolean res7 = MutantLogic.isMutant(dna7);
        boolean res8 = MutantLogic.isMutant(dna8);
        boolean res9 = MutantLogic.isMutant(dna9);
        boolean res10 = MutantLogic.isMutant(dna10);
        boolean res11 = MutantLogic.isMutant(dna11);
        boolean res12 = MutantLogic.isMutant(dna12);
        boolean res13 = MutantLogic.isMutant(dna13);
        boolean res14 = MutantLogic.isMutant(dna14);
        boolean res15 = MutantLogic.isMutant(dna15);
        boolean res16 = MutantLogic.isMutant(dna16);
        boolean res17 = MutantLogic.isMutant(dna17);

        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res1);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res2);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res3);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res4);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res5);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res6);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res7);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res8);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res9);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res10);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res11);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res12);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res13);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res14);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res15);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res16);
        assertTrue(TestDescriptor.TestFailedDescription(true,"Test failed, dna is mutant but method returned false"), res17);
    }

    @Test
    public void Test005ValidationFailsWhenDnaIsNotValid()
    {
        String[] dna1 = {};
        String[] dna2 = {"T", "AA"};
        String[] dna3 = {"aT", "bF"};

        boolean res1 = MutantLogic.isMutant(dna1);
        boolean res2 = MutantLogic.isMutant(dna2);
        boolean res3 = MutantLogic.isMutant(dna3);

        assertFalse(TestDescriptor.TestFailedDescription(false,"Test failed, dna is human but method returned true"), res1);
        assertFalse(TestDescriptor.TestFailedDescription(false,"Test failed, dna is human but method returned true"), res2);
        assertFalse(TestDescriptor.TestFailedDescription(false,"Test failed, dna is human but method returned true"), res3);
    }
}
