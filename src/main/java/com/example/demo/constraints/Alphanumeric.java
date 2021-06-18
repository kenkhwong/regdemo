package com.example.demo.constraints;

import com.example.demo.validator.AlphanumericValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = AlphanumericValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Alphanumeric {
    String message() default "Must be alphanumeric";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
