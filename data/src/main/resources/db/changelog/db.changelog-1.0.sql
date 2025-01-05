--liquibase formatted sql

--changeset Evgenii:1
CREATE TABLE IF NOT EXISTS positions
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(40) NOT NULL UNIQUE,
    dt_create TIMESTAMP   NOT NULL,
    dt_update TIMESTAMP   NOT NULL
);

--changeset Evgenii:2
CREATE TABLE IF NOT EXISTS employees
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstname   VARCHAR(20) NOT NULL,
    lastname    VARCHAR(40) NOT NULL,
    patronymic  VARCHAR(40) NOT NULL,
    email       VARCHAR(50) NOT NULL UNIQUE,
    dt_create   TIMESTAMP   NOT NULL,
    dt_update   TIMESTAMP   NOT NULL,
    position_id INT         NOT NULL,
    CONSTRAINT fk_position FOREIGN KEY (position_id) REFERENCES positions (id)
);

--changeset Evgenii:3
CREATE TABLE IF NOT EXISTS projects
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(60)  NOT NULL UNIQUE,
    description VARCHAR(150) NOT NULL,
    dt_create   TIMESTAMP    NOT NULL,
    dt_update   TIMESTAMP    NOT NULL
);

--changeset Evgenii:4
CREATE TABLE IF NOT EXISTS projects_employee
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT    NOT NULL,
    project_id  BIGINT    NOT NULL,
    dt_create   TIMESTAMP NOT NULL,
    dt_update   TIMESTAMP NOT NULL,
    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employees (id),
    CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES projects (id)
);
