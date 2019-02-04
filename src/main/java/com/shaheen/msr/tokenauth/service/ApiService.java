package com.shaheen.msr.tokenauth.service;

import com.shaheen.msr.tokenauth.request.FeatureRequest;
import com.shaheen.msr.tokenauth.response.FeatureResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ApiService {
    public FeatureResponse getFeature(FeatureRequest request) {

        if (request.getMsisdn().endsWith("01"))
            throw new RuntimeException("CustomException");

        FeatureResponse response = new FeatureResponse();
        response.setFeatureName("TestFeatureName");
        response.setFeatureDescription("TestFeatureDescription");


        return response;

    }
}
