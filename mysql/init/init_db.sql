CREATE DATABASE project;

USE project;

CREATE USER 'app_user'@'%' IDENTIFIED BY '12345';

GRANT ALL PRIVILEGES ON project.* TO 'app_user'@'%';
