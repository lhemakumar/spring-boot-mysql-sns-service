/*
package com.rc.core.service.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.rc.core.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmazonSNSPublisherService implements PublisherService {

    private AmazonSNS amazonSNS;
    private String snsTopicDemoARN;

    @Autowired
    public AmazonSNSPublisherService(BasicSessionCredentials sessionCredentials, String snsTopicDemoARN) {

        this.amazonSNS = AmazonSNSClientBuilder.standard().withRegion(Regions.EU_WEST_2).withCredentials(new AWSStaticCredentialsProvider(sessionCredentials)).build();
        this.snsTopicDemoARN = snsTopicDemoARN;


    }

    @Override
    public void publish(User user) throws Exception {

        String snsTopic = getTopicARN(snsTopicDemoARN);
        PublishRequest publishRequest = new PublishRequest(snsTopic, user.getMessage(), "User Addition " + user.getName());

        PublishResult publishResult = this.amazonSNS.publish(publishRequest);

        //Use log4j
        System.out.println("MessageId - " + publishResult.getMessageId());
    }

    private String getTopicARN(String topic) throws Exception {
        switch (topic) {
            case AWS_SNS:
                return this.snsTopicDemoARN;
            default:
                throw new RuntimeException("No matching topic supported!");
        }
    }
}
*/
