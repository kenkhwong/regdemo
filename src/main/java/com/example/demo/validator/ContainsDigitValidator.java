package com.example.demo.validator;

import com.example.demo.constraints.ContainsDigit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContainsDigitValidator implements ConstraintValidator<ContainsDigit,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        for (Character c : value.toCharArray()) {
            if (Character.isDigit(c))
                return true;
        }

        return false;
    }
}
