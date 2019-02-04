package com.shaheen.msr.tokenauth.controller;

import com.shaheen.msr.tokenauth.request.FeatureRequest;
import com.shaheen.msr.tokenauth.response.FeatureResponse;
import com.shaheen.msr.tokenauth.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping(value = "/feature",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public FeatureResponse getFeature(@Valid @RequestBody FeatureRequest request) {
        log.info("ApiController | Feature Request : {}", request.toString());



        return apiService.getFeature(request);
    }
}
