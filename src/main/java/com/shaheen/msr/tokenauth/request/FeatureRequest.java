package com.shaheen.msr.tokenauth.request;

import com.shaheen.msr.tokenauth.validation.ServiceName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class FeatureRequest implements Serializable {
    @NotNull(message = "{msisdn.notNull}")
    @Pattern(regexp="^01\\d{9}$",message = "{msisdn.valid}")
    private String msisdn;

    @NotNull(message = "{simSerial.notNull}")
    @Size(min=10,max=30, message="{simSerial.length}")
    private String simSerial;

    @NotNull(message = "{fingerPrint.notNull}")
    private String fingerPrint;

    @NotNull(message = "{serviceName.notNull}")
    @ServiceName
    private String serviceName;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getSimSerial() {
        return simSerial;
    }

    public void setSimSerial(String simSerial) {
        this.simSerial = simSerial;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "StatusRequest{" +
                "msisdn='" + msisdn + '\'' +
                ", simSerial='" + simSerial + '\'' +
                ", fingerPrint='" + fingerPrint + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
