package com.meli.MercadolibreChallenge.Test.Infrastructure.Repositories;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.meli.MercadolibreChallenge.Domain.Entities.DnaHumanMutantRatio;
import com.meli.MercadolibreChallenge.Infrastructure.Configuration.DynamoDbConfig;
import com.meli.MercadolibreChallenge.Infrastructure.Repositories.DnaHumanMutantRatioRepository;
import com.meli.MercadolibreChallenge.Test.Util.ExceptionDescriptor;
import com.meli.MercadolibreChallenge.Test.Util.TestDescriptor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DynamoDbConfig.class, DnaHumanMutantRatio.class})
@WebAppConfiguration
public class DnaHumanMutantRatioRepositoryTests
{
    private DynamoDBMapper dynamoDBMapper;

    Logger logger = LoggerFactory.getLogger(DnaHumanMutantRatio.class);

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    DnaHumanMutantRatioRepository dnaHumanMutantRatioRepository;

    /*Tries to connect to the database before initialization of tests*/
    @Before
    public void setup() throws Exception {
        try
        {
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(DnaHumanMutantRatio.class);
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
    public void dnaHumanMutantRatioGetStatsSucceds() throws Exception{
       /* TODO: ADD Test validation for fetching all stats,
            for stats to show ok when adding human, for status to show ok when adding mutant, and for human/mutant ratio calculation to be ok.
            */
/*
        var dnaHumanMutantRatio = new DnaHumanMutantRatio();

        dnaHumanMutantRatio.setDnaHumanMutantRatioID("stats");
        dnaHumanMutantRatio.setMutantCount(1);
        dnaHumanMutantRatio.setHumanCount(2);

        try
        {
            var resBeforeAddition = dnaHumanMutantRatioRepository.count();

            dnaHumanMutantRatioRepository.save(dnaHumanMutantRatio);

            assertTrue(TestDescriptor.TestFailedDescription(true, "Insertion of dna failed"), resBeforeAddition + 1 == dnaHumanMutantRatioRepository.count());
        }
        catch(Exception ex)
        {
            logger.error(ExceptionDescriptor.ExceptionOcurred("ResourceInUseException", ex.getMessage()));

            throw new Exception("Failed to initialize database connection or table creation context for test execution");
        }
*/
    }
}
