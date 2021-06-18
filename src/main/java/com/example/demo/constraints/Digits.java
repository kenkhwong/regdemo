package com.example.demo.constraints;

import com.example.demo.validator.DigitsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = DigitsValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Digits {
    String message() default "Must be digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
