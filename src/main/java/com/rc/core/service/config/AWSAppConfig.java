package com.rc.core.service.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AWSAppConfig {

    private static final Integer TEMPORARY_CREDENTIALS_DURATION_DEFAULT = 7200;

    @Value("${aws.temporary.credentials.validity.duration}")
    String credentialsValidityDuration;

    @Value("${aws.sns.topic.ARN}")
    String snsTopicDemoARN;

    @Bean(name = "snsTopicDemoARN")
    public String snsTopcARN() {
        return this.snsTopicDemoARN;
    }

    @Primary
    @Bean
    public AmazonSNSClient amazonSNSClient() {
        return (AmazonSNSClient) AmazonSNSClientBuilder
                .standard()
                .withRegion(Regions.EU_WEST_2)
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                        "",
                                        ""
                                )
                        )
                )
                .build();
    }
}
