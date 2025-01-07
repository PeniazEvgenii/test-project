package by.it_academy.service.service;

import by.it_academy.data.repository.entity.Employee;
import by.it_academy.service.IntegrationTestBase;
import by.it_academy.service.service.api.IEmployeeService;
import by.it_academy.service.service.dto.EmployeeDto;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class EmployeeServiceIT extends IntegrationTestBase {

    private final IEmployeeService employeeService;

    @Test
    void create() {
        EmployeeDto employeeDto = EmployeeDto.builder()
                .email("test@test.com")
                .firstname("Test")
                .lastname("Test")
                .patronymic("Test")
                .position("test")
                .build();
        assertFalse(employeeService.existByMail("test@test.com"));
        employeeService.create(employeeDto);
        assertTrue(employeeService.existByMail("test@test.com"));

        assertThrows(ConstraintViolationException.class, ()  -> employeeService.create(employeeDto));

    }

    @Test
    void findById() {
        Optional<Employee> maybeEmployee = employeeService.findById(1L);
        assertTrue(maybeEmployee.isPresent());

        maybeEmployee.ifPresent(employee -> assertEquals("ivan@example.com", employee.getEmail()));
    }
}