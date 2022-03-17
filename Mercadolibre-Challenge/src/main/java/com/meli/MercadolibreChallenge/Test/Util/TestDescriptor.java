package com.meli.MercadolibreChallenge.Test.Util;

public class TestDescriptor
{
    public static String TestFailedDescription(Boolean expectedValue, String errorDescription)
    {
        var expectedDescription = expectedValue ? "True" : "False";
        var currentDescription = expectedValue ? "False" : "True";

        return "Expected value: "+expectedDescription+". Current value: "+currentDescription+". ErrorDescription: "+errorDescription+"";
    }
}
