package com.example.demo.validator;

import com.example.demo.constraints.Digits;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DigitsValidator implements ConstraintValidator<Digits,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        for (Character c : value.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }

        return true;
    }
}
