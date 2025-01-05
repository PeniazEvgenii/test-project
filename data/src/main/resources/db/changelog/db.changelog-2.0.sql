--liquibase formatted sql

--changeset Evgenii:1
ALTER TABLE project.projects_employee
ADD CONSTRAINT project_employee_unique UNIQUE (employee_id, project_id);

