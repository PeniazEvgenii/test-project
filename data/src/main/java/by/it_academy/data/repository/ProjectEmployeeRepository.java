package by.it_academy.data.repository;

import by.it_academy.data.repository.entity.ProjectEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee, Long> {
}
