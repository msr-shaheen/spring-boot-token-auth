package com.shaheen.msr.tokenauth.validation;

import com.shaheen.msr.tokenauth.utility.Utility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ServiceNameValidator implements ConstraintValidator<ServiceName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            for (Utility.SERVICES choice : Utility.SERVICES.values()) {
                if (choice.name().equals(value))
                    return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }
}