package com.example.demo.constraints;

import com.example.demo.validator.ContainsDigitValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = ContainsDigitValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContainsDigit {
    String message() default "Must have at least one digit";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
