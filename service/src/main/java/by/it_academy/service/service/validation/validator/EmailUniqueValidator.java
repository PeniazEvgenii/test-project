package by.it_academy.service.service.validation.validator;

import by.it_academy.service.service.api.IEmployeeService;
import by.it_academy.service.service.validation.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailUniqueValidator implements ConstraintValidator<UniqueEmail, String> {

    private final IEmployeeService employeeService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !employeeService.existByMail(value);
    }
}
