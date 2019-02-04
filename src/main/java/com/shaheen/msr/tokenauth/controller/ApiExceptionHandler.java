package com.shaheen.msr.tokenauth.controller;

import com.shaheen.msr.tokenauth.response.ErrorResponse;
import com.shaheen.msr.tokenauth.utility.Utility;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.shaheen.msr.tokenauth.response.ErrorDetails;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorDetails> errorDetailsList = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ErrorDetails(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setUpdateTime(Utility.formattedDateTime(new Date()));
        errorResponse.setErrorMessageEn(Utility.INVALID_REQUEST_BODY_MESSAGE_EN);
        errorResponse.setErrorMessageBn(Utility.PROCESS_FAILED_MESSAGE_BN);
        errorResponse.setErrorDetails(errorDetailsList);

        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        final Throwable rootCause = ExceptionUtils.getRootCause(ex);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setUpdateTime(Utility.formattedDateTime(new Date()));
        errorResponse.setErrorMessageEn(ex.getMessage());
        errorResponse.setErrorMessageBn(Utility.PROCESS_FAILED_MESSAGE_BN);

        log.info("Exception occurred !!! {}", ex.getMessage());

        errorResponse.setErrorCode(HttpStatus.FORBIDDEN.value());
        return buildResponseEntity(errorResponse, HttpStatus.FORBIDDEN);
    }

    private ResponseEntity<ErrorResponse> buildResponseEntity(ErrorResponse errorResponse, HttpStatus httpStatus) {
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
