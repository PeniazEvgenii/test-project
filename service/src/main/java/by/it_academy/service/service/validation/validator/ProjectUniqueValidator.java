package by.it_academy.service.service.validation.validator;

import by.it_academy.service.service.api.IProjectService;
import by.it_academy.service.service.validation.UniqueProjectName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectUniqueValidator implements ConstraintValidator<UniqueProjectName, String> {

    private final IProjectService projectService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !projectService.existByName(value);
    }
}
