package by.it_academy.service.service;

import by.it_academy.data.repository.entity.Project;
import by.it_academy.service.IntegrationTestBase;
import by.it_academy.service.service.api.IProjectService;
import by.it_academy.service.service.dto.PageDto;
import by.it_academy.service.service.dto.PageOf;
import by.it_academy.service.service.dto.ProjectDto;
import by.it_academy.service.service.dto.ProjectReadDto;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
class ProjectServiceIT extends IntegrationTestBase {

    private final IProjectService projectService;

    @Test
    void create() {
        ProjectDto projectDto = new ProjectDto("test", "test project");
        assertFalse(projectService.existByName("test"));
        projectService.create(projectDto);
        assertTrue(projectService.existByName("test"));

        assertThrows(ConstraintViolationException.class, ()  -> projectService.create(projectDto));

        ProjectDto projectDtoBlank = new ProjectDto("test2", "    ");
        assertFalse(projectService.existByName("test2"));
        assertThrows(ConstraintViolationException.class, ()  -> projectService.create(projectDtoBlank));
    }

    @Test
    void findAll() {
        PageDto pageDto = new PageDto(0, 10);
        PageOf<ProjectReadDto> allProject = projectService.findAll(pageDto);

        assertEquals(0, allProject.getNumber());
        assertEquals(10, allProject.getSize());
        assertEquals(3, allProject.getTotalElements());

        assertThat(allProject.getContent()).hasSize(3);
    }

    @Test
    void findById() {
        Optional<Project> maybeProject = projectService.findById(1L);
        assertTrue(maybeProject.isPresent());

        maybeProject.ifPresent(project -> assertEquals("Project_One", project.getName()));
    }

}