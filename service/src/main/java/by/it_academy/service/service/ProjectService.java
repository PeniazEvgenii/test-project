package by.it_academy.service.service;

import by.it_academy.data.repository.ProjectRepository;
import by.it_academy.data.repository.entity.Project;
import by.it_academy.service.service.api.IProjectService;
import by.it_academy.service.service.dto.PageDto;
import by.it_academy.service.service.dto.PageOf;
import by.it_academy.service.service.dto.ProjectDto;
import by.it_academy.service.service.dto.ProjectReadDto;
import by.it_academy.service.service.mapper.IProjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectService implements IProjectService {

    private final ProjectRepository projectRepository;
    private final IProjectMapper projectMapper;

    @Transactional
    @Override
    public void create(@Valid ProjectDto projectDto) {

        Optional.of(projectDto)
                .map(projectMapper::toEntity)
                .map(projectRepository::saveAndFlush);
    }

    @Override
    public PageOf<ProjectReadDto> findAll(@Valid PageDto pageDto) {

        Sort sortProject = Sort.sort(Project.class)
                .by(Project::getName)
                .ascending();

        PageRequest pageRequest = PageRequest.of(
                pageDto.getPage(),
                pageDto.getSize(),
                sortProject);

        Page<ProjectReadDto> page = projectRepository.findAll(pageRequest)
                .map(projectMapper::toDto);

        return PageOf.of(page);
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public boolean existByName(String name) {
        return projectRepository.existsByName(name);
    }

}
