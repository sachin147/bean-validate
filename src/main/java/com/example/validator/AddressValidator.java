package com.example.validator;

import com.example.bean.Address;
import com.example.constraint.ValidAddress;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AddressValidator implements ConstraintValidator<ValidAddress, Address> {

    @Override
    public void initialize(ValidAddress constraintAnnotation) {

    }

    @Override
    public boolean isValid(Address address, ConstraintValidatorContext constraintValidatorContext) {


        constraintValidatorContext.disableDefaultConstraintViolation();
        HibernateConstraintValidatorContext hibernateContext = constraintValidatorContext.unwrap(HibernateConstraintValidatorContext.class);

        return false;
    }
}
