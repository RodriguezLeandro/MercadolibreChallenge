package com.meli.MercadolibreChallenge.Logic.Mutant;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.meli.MercadolibreChallenge.Domain.Entities.Customer;
import com.meli.MercadolibreChallenge.Infrastructure.CustomerService;
import com.meli.MercadolibreChallenge.Infrastructure.Repositories.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = com.meli.MercadolibreChallenge.Domain.RepositoryServices.MutantRepositoryService.class)
@ComponentScan(basePackages = "com.meli.MercadolibreChallenge")
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = {
        "amazon.dynamodb.endpoint=http://localhost:8000/",
        "amazon.aws.accesskey=test1",
        "amazon.aws.secretkey=test231" })

public class MutantLogicTests {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    CustomerRepository customerRepository;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setCustomerID("CUST-001");
        customer.setName("pratik");
        customer.setEmail("hgjgjh");
        customerRepository.save(customer);
    }
}