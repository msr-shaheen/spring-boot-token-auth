package com.shaheen.msr.tokenauth.response;

import java.io.Serializable;

public class FeatureResponse extends ErrorResponse implements Serializable {
    private String featureName;
    private String featureDescription;

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureDescription() {
        return featureDescription;
    }

    public void setFeatureDescription(String featureDescription) {
        this.featureDescription = featureDescription;
    }

    @Override
    public String toString() {
        return "FeatureResponse{" +
                "featureName='" + featureName + '\'' +
                ", featureDescription='" + featureDescription + '\'' +
                "} " + super.toString();
    }
}
