package by.it_academy.service.service.validation.validator;

import by.it_academy.service.service.validation.LatinLetters;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class LatinLettersValidator implements ConstraintValidator<LatinLetters, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^[a-zA-Z\\s]+$");
    }
}
