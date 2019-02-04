package com.shaheen.msr.tokenauth.response;

import java.io.Serializable;
import java.util.List;

public class ErrorResponse implements Serializable {
    private int errorCode;
    private String errorMessageEn;
    private String errorMessageBn;
    private String updateTime;
    private List<ErrorDetails> errorDetails;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessageEn() {
        return errorMessageEn;
    }

    public void setErrorMessageEn(String errorMessageEn) {
        this.errorMessageEn = errorMessageEn;
    }

    public String getErrorMessageBn() {
        return errorMessageBn;
    }

    public void setErrorMessageBn(String errorMessageBn) {
        this.errorMessageBn = errorMessageBn;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<ErrorDetails> getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(List<ErrorDetails> errorDetails) {
        this.errorDetails = errorDetails;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessageEn='" + errorMessageEn + '\'' +
                ", errorMessageBn='" + errorMessageBn + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", errorDetails=" + errorDetails +
                '}';
    }
}
