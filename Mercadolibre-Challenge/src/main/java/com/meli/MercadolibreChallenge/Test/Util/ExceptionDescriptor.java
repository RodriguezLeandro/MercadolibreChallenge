package com.meli.MercadolibreChallenge.Test.Util;

public class ExceptionDescriptor
{
    public static String ExceptionOcurred(String exceptionType, String errorMessage)
    {
        return "Exception ocurred: "+exceptionType+". Error description is: "+errorMessage+".";
    }
}
