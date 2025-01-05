package by.it_academy.service.service.api;

import by.it_academy.data.repository.entity.Project;
import by.it_academy.service.service.dto.PageDto;
import by.it_academy.service.service.dto.PageOf;
import by.it_academy.service.service.dto.ProjectDto;
import by.it_academy.service.service.dto.ProjectReadDto;
import jakarta.validation.Valid;

import java.util.Optional;

public interface IProjectService {

    void create(@Valid ProjectDto projectDto);

    PageOf<ProjectReadDto> findAll(@Valid PageDto pageDto);

    Optional<Project> findById(Long id);

    boolean existByName(String name);
}
