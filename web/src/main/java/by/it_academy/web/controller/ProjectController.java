package by.it_academy.web.controller;

import by.it_academy.service.service.api.IProjectService;
import by.it_academy.service.service.dto.PageDto;
import by.it_academy.service.service.dto.PageOf;
import by.it_academy.service.service.dto.ProjectDto;
import by.it_academy.service.service.dto.ProjectReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final IProjectService projectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProjectDto projectDto) {

        projectService.create(projectDto);
    }

    @GetMapping
    public PageOf<ProjectReadDto> getAll(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {

        return projectService.findAll(new PageDto(page, size));
    }
}
