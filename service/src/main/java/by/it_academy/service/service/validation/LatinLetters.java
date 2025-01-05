package by.it_academy.service.service.validation;

import by.it_academy.service.service.validation.validator.LatinLettersValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LatinLettersValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LatinLetters {

    String message() default "The field must contain only Latin letters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
