package com.example.demo.validator;

import com.example.demo.constraints.ContainsUpperCase;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContainsUpperCaseValidator implements ConstraintValidator<ContainsUpperCase,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        for (Character c : value.toCharArray()) {
            if (Character.isUpperCase(c))
                return true;
        }

        return false;
    }
}
