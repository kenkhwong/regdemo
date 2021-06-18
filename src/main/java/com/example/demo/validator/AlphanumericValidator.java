package com.example.demo.validator;

import com.example.demo.constraints.Alphanumeric;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphanumericValidator implements ConstraintValidator<Alphanumeric,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        for (Character c : value.toCharArray()) {
            if (!Character.isLetterOrDigit(c))
                return false;
        }

        return true;
    }
}
