package com.example.validator;

import com.example.constraint.ValidName;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String>, ApplicationContextAware {

    private SpelExpressionParser spelExpressionParser;
    private StandardEvaluationContext standardEvaluationContext;
    private String name;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.spelExpressionParser = new SpelExpressionParser();
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
        standardEvaluationContext.setBeanResolver(new BeanFactoryResolver(applicationContext.getAutowireCapableBeanFactory()));
        this.standardEvaluationContext = standardEvaluationContext;
    }

    @Override
    public void initialize(ValidName constraintAnnotation) {
        Object expressionResult = spelExpressionParser.parseExpression(constraintAnnotation.value()).getValue(standardEvaluationContext);
        if(expressionResult != null && String.class.isAssignableFrom(expressionResult.getClass())) {
            name = (String) expressionResult;
        }
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.equals(name);
    }

}
