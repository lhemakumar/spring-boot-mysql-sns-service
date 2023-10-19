package com.rc.core.service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.rc.core.service.aws.PublisherService;
import com.rc.core.service.dao.UserRepository;
import com.rc.core.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.rc.core.service.aws.PublisherService.AWS_SNS;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AmazonSNSClient amazonSNSClient;
    @Override
    public User addUser(User user) {
        System.out.println("User Name:"+user.getName());
        System.out.println("User Email:"+user.getEmail());
        final User userObj = userRepository.save(user);
        try {
            PublishRequest publishRequest =
                    new PublishRequest(AWS_SNS,user.getMessage(),"User added" );
            amazonSNSClient.publish(publishRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userObj;
    }
}
