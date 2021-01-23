package com.example.constraint;


import com.example.validator.NameValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface ValidName {

    String value() ;

    @Documented
    @Inherited
    @Target({ ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        ValidName[] value();
    }
}
