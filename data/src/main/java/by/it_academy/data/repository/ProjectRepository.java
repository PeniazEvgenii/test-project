package by.it_academy.data.repository;

import by.it_academy.data.repository.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
