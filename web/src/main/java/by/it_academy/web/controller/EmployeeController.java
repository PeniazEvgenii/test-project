package by.it_academy.web.controller;

import by.it_academy.service.service.api.IEmployeeService;
import by.it_academy.service.service.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody EmployeeDto employeeDto) {

        employeeService.create(employeeDto);
    }
}
