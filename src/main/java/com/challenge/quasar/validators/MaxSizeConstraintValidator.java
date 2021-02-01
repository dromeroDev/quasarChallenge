package com.challenge.quasar.validators;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.challenge.quasar.entities.Satellite;

public class MaxSizeConstraintValidator implements ConstraintValidator<MaxSizeConstraint, List<Satellite>> {
    @Override
    public boolean isValid(List<Satellite> values, ConstraintValidatorContext context) {
        return values.size() <= 2;
    }
}