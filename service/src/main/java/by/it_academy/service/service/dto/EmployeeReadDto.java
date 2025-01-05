package by.it_academy.service.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeReadDto {

    private String lastname;

    private String firstname;

    private String patronymic;
}
