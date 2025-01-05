package by.it_academy.service.service.dto;

import by.it_academy.service.service.validation.LatinLetters;
import by.it_academy.service.service.validation.UniqueProjectName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectDto {

    @UniqueProjectName
    @NotBlank(message = "Project name not specified")
    @Size(max = 60, message = "Project name must be no more than 60 characters")
    @LatinLetters
    private final String name;

    @NotBlank(message = "Project description not specified")
    @Size(max = 150, message = "Project description must be no more than 150 characters")
    @LatinLetters
    private final String description;
}
