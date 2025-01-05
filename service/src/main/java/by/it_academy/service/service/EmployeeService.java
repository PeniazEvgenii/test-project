package by.it_academy.service.service;

import by.it_academy.data.repository.EmployeeRepository;
import by.it_academy.data.repository.entity.Employee;
import by.it_academy.data.repository.entity.Position;
import by.it_academy.service.service.api.IEmployeeService;
import by.it_academy.service.service.api.IPositionService;
import by.it_academy.service.service.dto.EmployeeDto;
import by.it_academy.service.service.mapper.IEmployeeMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Validated
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final IEmployeeMapper employeeMapper;
    private final IPositionService positionService;

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public void create(@Valid EmployeeDto employeeDto) {

        Position position = positionService.findOrCreate(employeeDto.getPosition());
        Employee employee = employeeMapper.toEnity(employeeDto, position);

        employeeRepository.saveAndFlush(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean existByMail(String mail) {
        return employeeRepository.existsByEmailIgnoreCase(mail);
    }
}
