package by.it_academy.service.service.api;

import by.it_academy.data.repository.entity.Employee;
import by.it_academy.service.service.dto.EmployeeDto;
import jakarta.validation.Valid;

import java.util.Optional;

public interface IEmployeeService {

    void create(@Valid EmployeeDto employeeDto);

    Optional<Employee> findById(Long id);

    boolean existByMail(String mail);
}
