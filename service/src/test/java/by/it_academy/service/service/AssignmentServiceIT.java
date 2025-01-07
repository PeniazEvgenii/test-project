package by.it_academy.service.service;

import by.it_academy.data.repository.ProjectEmployeeRepository;
import by.it_academy.data.repository.entity.ProjectEmployee;
import by.it_academy.service.IntegrationTestBase;
import by.it_academy.service.service.api.IAssignmentService;
import by.it_academy.service.service.dto.EmployeeForProjectDto;
import by.it_academy.service.service.validation.exception.EmployeeNotAddException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@RequiredArgsConstructor
public class AssignmentServiceIT extends IntegrationTestBase {

    private final IAssignmentService assignmentService;
    private final ProjectEmployeeRepository repository;

    @Test
    void create() {
        EmployeeForProjectDto existEmployeeProject = new EmployeeForProjectDto(2L, 2L);
        assertThrows(EmployeeNotAddException.class, ()  -> assignmentService.create(existEmployeeProject));

        EmployeeForProjectDto employeeForProjectDto = new EmployeeForProjectDto(2L, 3L);

        List<ProjectEmployee> allBefore = repository.findAll();
        assertThat(allBefore).hasSize(5);

        assignmentService.create(employeeForProjectDto);

        List<ProjectEmployee> allAfter = repository.findAll();
        assertThat(allAfter).hasSize(6);
    }
}