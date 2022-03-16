package com.meli.MercadolibreChallenge.Presentation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.meli.MercadolibreChallenge.Infrastructure.Repositories.CustomerRepository")
public class DynamoDbConfig {
    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AWSCredentialsProvider credentials =
                new ProfileCredentialsProvider("default");
        AmazonDynamoDB amazonDynamoDB
                = AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(credentials)
                .build();

        return amazonDynamoDB;
    }
    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
                "22", "223");
    }
}
