INSERT INTO positions (id,name, dt_create, dt_update)
VALUES (1, 'Engineer', NOW(), NOW()),
       (2, 'Manager', NOW(), NOW()),
       (3, 'Scientist', NOW(), NOW());

INSERT INTO employees (id, firstname, lastname, patronymic, email, dt_create, dt_update, position_id)
VALUES (1, 'Ivan', 'Ivanov', 'Ivanovich', 'ivan@example.com', NOW(), NOW(),
        (SELECT id FROM positions WHERE name = 'Engineer')),
       (2, 'Petr', 'Petrov', 'Petrovich', 'petr@example.com', NOW(), NOW(),
        (SELECT id FROM positions WHERE name = 'Manager')),
       (3, 'Maria', 'Maria', 'Petrovna', 'maria@example.com', NOW(), NOW(),
        (SELECT id FROM positions WHERE name = 'Scientist'));

INSERT INTO projects (id, name, description, dt_create, dt_update)
VALUES (1, 'Project_One', '1 project...', NOW(), NOW()),
       (2, 'Project_Two', '2 project...', NOW(), NOW()),
       (3, 'Project_Three', '3 project ...', NOW(), NOW());

INSERT INTO projects_employee (employee_id, project_id, dt_create, dt_update)
VALUES (1, 1, NOW(), NOW()),
       (1, 2, NOW(), NOW()),
       (1, 3, NOW(), NOW()),
       (2, 2, NOW(), NOW()),
       (3, 3, NOW(), NOW());