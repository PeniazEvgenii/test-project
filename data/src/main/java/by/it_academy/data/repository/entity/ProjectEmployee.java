package by.it_academy.data.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "projects_employee")
public class ProjectEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id")
    private Project project;

    @CreatedDate
    @Column(name = "dt_create", nullable = false)
    private Instant dtCreate;

    @LastModifiedDate
    @Column(name = "dt_update", nullable = false)
    private Instant dtUpdate;

    public void setEmployee(Employee employee) {
        this.employee = employee;
        this.employee.getProjectEmployees().add(this);
    }

    public void setProject(Project project) {
        this.project = project;
        this.project.getProjectEmployees().add(this);
    }
}
