package by.it_academy.service.service.validation;

import by.it_academy.service.service.validation.validator.EmailUniqueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = EmailUniqueValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "The specified email is already registered in the system";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
