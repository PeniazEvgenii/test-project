package by.it_academy.service.service.dto;

import by.it_academy.service.service.validation.LatinLetters;
import by.it_academy.service.service.validation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

    @NotBlank(message = "Lastname not specified")
    @Size(max = 40, message = "Lastname must be no more than 40 characters")
    @LatinLetters
    private final String lastname;

    @NotBlank(message = "Firstname not specified")
    @Size(max = 20, message = "Firstname must be no more than 20 characters")
    @LatinLetters
    private final String firstname;

    @NotBlank(message = "Patronymic not specified")
    @Size(max = 40, message = "Patronymic must be no more than 40 characters")
    @LatinLetters
    private final String patronymic;

    @Email
    @UniqueEmail
    @Size(max = 50, message = "Email must be no more than 50 characters")
    private final String email;


    @NotBlank(message = "Position not specified")
    @LatinLetters
    @Size(max = 40, message = "Position must be no more than 40 characters")
    private final String position;
}
