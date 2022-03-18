package com.meli.MercadolibreChallenge.Domain.Entities;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "DnaHumanMutantRatio")
public class DnaHumanMutantRatio
{
    private String dnaHumanMutantRatioID;

    private int humanCount;

    private int mutantCount;

    @DynamoDBHashKey(attributeName = "DnaHumanMutantRatioID")
    public String getDnaHumanMutantRatioID()
    {
        return dnaHumanMutantRatioID;
    }

    public void setDnaHumanMutantRatioID(String dnaHumanMutantRatioID)
    {
        this.dnaHumanMutantRatioID = dnaHumanMutantRatioID;
    }

    @DynamoDBAttribute(attributeName = "HumanCount")
    public int getHumanCount()
    {
        return this.humanCount;
    }

    public void setHumanCount(int humanCount)
    {
        this.humanCount = humanCount;
    }

    @DynamoDBAttribute(attributeName = "MutantCount")
    public int getMutantCount()
    {
        return this.mutantCount;
    }


    public void setMutantCount(int mutantCount)
    {
        this.mutantCount = mutantCount;
    }

}
