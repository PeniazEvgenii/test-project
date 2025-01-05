package by.it_academy.service.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectReadDto {

    private final String name;

    private final String description;

    private final List<EmployeeReadDto> employees;
}
