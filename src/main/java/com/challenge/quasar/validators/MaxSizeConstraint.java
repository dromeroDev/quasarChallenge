package com.challenge.quasar.validators;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = MaxSizeConstraintValidator.class)
public @interface MaxSizeConstraint {
	String message() default "The input list cannot contain less than 3 items.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
