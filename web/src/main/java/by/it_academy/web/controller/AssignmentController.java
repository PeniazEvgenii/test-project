package by.it_academy.web.controller;

import by.it_academy.service.service.api.IAssignmentService;
import by.it_academy.service.service.dto.EmployeeForProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignments")
public class AssignmentController {

    private final IAssignmentService assignmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody EmployeeForProjectDto dto) {
        assignmentService.create(dto);
    }
}
