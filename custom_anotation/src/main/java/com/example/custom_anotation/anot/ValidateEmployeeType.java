package com.example.custom_anotation.anot;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmployeeTypeValidator.class)
public @interface ValidateEmployeeType {
    public String message() default "Invalid employeeType: It should be either Permanent Or Vendor";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
