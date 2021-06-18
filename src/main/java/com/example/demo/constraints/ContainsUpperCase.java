package com.example.demo.constraints;

import com.example.demo.validator.ContainsUpperCaseValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = ContainsUpperCaseValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContainsUpperCase {
    String message() default "Must have at least one uppercase letter";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
