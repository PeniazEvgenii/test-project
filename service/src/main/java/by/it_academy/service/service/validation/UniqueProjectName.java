package by.it_academy.service.service.validation;


import by.it_academy.service.service.validation.validator.ProjectUniqueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ProjectUniqueValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueProjectName {
    String message() default "Project with the specified name already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
