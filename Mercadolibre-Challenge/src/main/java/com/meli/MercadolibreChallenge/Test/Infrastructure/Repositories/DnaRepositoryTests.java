package com.meli.MercadolibreChallenge.Test.Infrastructure.Repositories;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.meli.MercadolibreChallenge.Domain.Entities.Dna;
import com.meli.MercadolibreChallenge.Infrastructure.Repositories.DnaRepository;
import com.meli.MercadolibreChallenge.Infrastructure.Configuration.DynamoDbConfig;
import com.meli.MercadolibreChallenge.Test.Util.ExceptionDescriptor;
import com.meli.MercadolibreChallenge.Test.Util.TestDescriptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DynamoDbConfig.class, Dna.class})
@WebAppConfiguration
public class DnaRepositoryTests {

    private DynamoDBMapper dynamoDBMapper;

    Logger logger = LoggerFactory.getLogger(Dna.class);

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    DnaRepository dnaRepository;

    /*Tries to connect to the database before initialization of tests*/
    @Before
    public void setup() throws Exception {
        try
        {
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(Dna.class);
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L));

            amazonDynamoDB.createTable(tableRequest);
        }catch(ResourceInUseException ex)
        {
            logger.error(ExceptionDescriptor.ExceptionOcurred("ResourceInUseException", ex.getErrorMessage()));
        }
        catch(Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Failed to initialize database connection or table creation context for test execution");
        }
    }

    @Test
    public void dnaInsertionSucceds() throws Exception{
        var dna = new Dna();

        var dnaData = Arrays.asList("ABC","DEF","GHI");

        String uniqueID = UUID.randomUUID().toString();

        dna.setDnaID(uniqueID);
        dna.setDna(dnaData);
        dna.setIsMutant(false);

        try
        {
            var resBeforeAddition = dnaRepository.count();

            dnaRepository.save(dna);

            assertTrue(TestDescriptor.TestFailedDescription(true, "Insertion of dna failed"), resBeforeAddition + 1 == dnaRepository.count());
        }
        catch(Exception ex)
        {
            logger.error(ExceptionDescriptor.ExceptionOcurred("ResourceInUseException", ex.getMessage()));

            throw new Exception("Failed to initialize database connection or table creation context for test execution");
        }
    }
}