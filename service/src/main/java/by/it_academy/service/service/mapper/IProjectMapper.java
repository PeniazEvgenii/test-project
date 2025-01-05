package by.it_academy.service.service.mapper;

import by.it_academy.data.repository.entity.Employee;
import by.it_academy.data.repository.entity.Project;
import by.it_academy.data.repository.entity.ProjectEmployee;
import by.it_academy.service.service.dto.EmployeeReadDto;
import by.it_academy.service.service.dto.ProjectDto;
import by.it_academy.service.service.dto.ProjectReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IProjectMapper {

    @Mapping(target = "projectEmployees", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dtUpdate", ignore = true)
    @Mapping(target = "dtCreate", ignore = true)
    Project toEntity(ProjectDto projectDto);

    @Mapping(source = "projectEmployees", target = "employees")
    ProjectReadDto toDto(Project project);

    List<ProjectReadDto> toDtoList(List<Project> projects);

    default EmployeeReadDto map(ProjectEmployee projectEmployee) {
        Employee employee = projectEmployee.getEmployee();

        return EmployeeReadDto.builder()
                .firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .patronymic(employee.getPatronymic())
                .build();
    }
}
