package com.rc.core.service.aws;

import com.rc.core.service.model.User;

public interface PublisherService {

    public static final String AWS_SNS = "SNS";

    void publish(User user) throws Exception;
}
