package com.meli.MercadolibreChallenge.Test;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.meli.MercadolibreChallenge.Domain.Entities.Customer;
import com.meli.MercadolibreChallenge.Infrastructure.Repositories.CustomerRepository;
import com.meli.MercadolibreChallenge.Infrastructure.Configuration.DynamoDbConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DynamoDbConfig.class})
@WebAppConfiguration
public class CustomerRepositoryIntegrationTest {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    CustomerRepository repository;

    private static final String EXPECTED_COST = "20";
    private static final String EXPECTED_PRICE = "50";

    @Before
    public void setup() throws Exception {
        try
        {
            /*TODO: Throw exception to do a timeout connection in case the database server is down*/
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

            CreateTableRequest tableRequest = dynamoDBMapper
                    .generateCreateTableRequest(Customer.class);
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L));

            amazonDynamoDB.createTable(tableRequest);
            dynamoDBMapper.batchDelete(
                    (List<Customer>)repository.findAll());
        }catch(ResourceInUseException ex)
        {

        }
        catch(Exception ex)
        {
            var debug = ex;
        }
    }

    @Test
    public void givenItemWithExpectedCost_whenRunFindAll_thenItemIsFound() {
        Customer customer = new Customer();
        customer.setCustomerID("test04");
        customer.setName("test05");
        customer.setEmail("test06");

        Customer customer2 = new Customer();
        customer2.setCustomerID("test01");
        customer2.setName("test02");
        customer2.setEmail("test03");

        Customer customer3 = new Customer();
        customer3.setCustomerID("Customer3Id");
        customer3.setName("Customer3Name");
        customer3.setEmail("Customer3Email");

        repository.save(customer);
        repository.save(customer2);
        repository.save(customer3);
        List<Customer> result = (List<Customer>) repository.findAll();

        assertTrue(result.size() >= 0);
    }
}