package com.meli.MercadolibreChallenge.Domain.Entities;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "Dna")
public class Dna
{
    private String dnaID;

    private List<String> dna;

    private boolean isMutant;

    @DynamoDBHashKey(attributeName = "DnaID")
    public String getDnaID() {
        return this.dnaID;
    }

    public void setDnaID(String dnaID) {
        this.dnaID = dnaID;
    }

    @DynamoDBAttribute(attributeName = "Dna")
    public List<String> getDna() {
        return this.dna;
    }

    public void setDna(List<String> dna) {
        this.dna = dna;
    }

    @DynamoDBAttribute(attributeName = "IsMutant")
    public boolean getIsMutant() {
        return this.isMutant;
    }

    public void setIsMutant(boolean isMutant) {
        this.isMutant = isMutant;
    }
}
