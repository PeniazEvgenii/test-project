package by.it_academy.service.service;

import by.it_academy.data.repository.ProjectEmployeeRepository;
import by.it_academy.data.repository.entity.Employee;
import by.it_academy.data.repository.entity.Project;
import by.it_academy.data.repository.entity.ProjectEmployee;
import by.it_academy.service.service.api.IAssignmentService;
import by.it_academy.service.service.api.IEmployeeService;
import by.it_academy.service.service.api.IProjectService;
import by.it_academy.service.service.dto.EmployeeForProjectDto;
import by.it_academy.service.service.validation.exception.EmployeeNotAddException;
import by.it_academy.service.service.validation.exception.IdNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AssignmentService implements IAssignmentService {

    private final ProjectEmployeeRepository repository;
    private final IEmployeeService employeeService;
    private final IProjectService projectService;

    @Transactional
    @Override
    public void create(EmployeeForProjectDto dto) {

        if(existsProjectEmployee(dto)) {
            throw new EmployeeNotAddException();
        }

        Employee employee = employeeService.findById(dto.getEmployeeId())
                .orElseThrow(() -> new IdNotFoundException("Incorrect employee ID"));

        Project project = projectService.findById(dto.getProjectId())
                .orElseThrow(() -> new IdNotFoundException("Incorrect project ID"));

        ProjectEmployee projectEmployee = new ProjectEmployee();
        projectEmployee.setEmployee(employee);
        projectEmployee.setProject(project);

        repository.saveAndFlush(projectEmployee);

    }

    private boolean existsProjectEmployee(EmployeeForProjectDto dto) {
        return repository.existsByEmployeeIdAndProjectId(
                dto.getEmployeeId(),
                dto.getProjectId());
    }
}
