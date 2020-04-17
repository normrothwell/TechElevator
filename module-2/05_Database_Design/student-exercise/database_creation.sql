BEGIN TRANSACTION;

CREATE TABLE employee
(
employee_id SERIAL NOT NULL, 
last_name VARCHAR (30) NOT NULL, 
first_name VARCHAR (30),
job_title VARCHAR (30),
gender CHAR (1),
date_of_birth DATE,
date_of_hire DATE,
department_id INTEGER
);

CREATE TABLE department
(
department_id SERIAL NOT NULL,
name VARCHAR (20)
);

CREATE TABLE employee_project
(
employee_id INTEGER,
project_id INTEGER
);

CREATE TABLE project
(
project_id SERIAL NOT NULL,
name VARCHAR (30),
start_date DATE
); 

COMMIT TRANSACTION;

BEGIN TRANSACTION;
ALTER TABLE employee ADD CONSTRAINT pk_employee PRIMARY KEY (employee_id);
Alter table department add constraint pk_department primary key (department_id);
Alter table project add constraint pk_project primary key (project_id);

ALTER TABLE employee ADD CONSTRAINT fk_department_id foreign key (department_id) references department(department_id);
ALTER TABLE employee_project ADD CONSTRAINT fk_employee_id FOREIGN KEY (employee_id) REFERENCES employee(employee_id);
ALTER TABLE employee_project ADD CONSTRAINT fk_project_id FOREIGN KEY (project_id) REFERENCES project(project_id);

COMMIT transaction;

INSERT INTO department (name) VALUES ('Design');
INSERT INTO department (name) VALUES ('HR');
INSERT INTO department (name) VALUES ('Testing');
INSERT INTO employee (last_name, first_name, job_title, gender, date_of_birth, date_of_hire, department_id) VALUES ('Stegmaier', 'Jamey', 'Designer', 'M', '1981-10-20', '2013-08-21', 1);
INSERT INTO employee (last_name, first_name, job_title, gender, date_of_birth, date_of_hire, department_id) VALUES ('Lang', 'Eric', 'Hiring Manager', 'M', '1972-12-7', '2000-01-02', 2);
INSERT INTO employee (last_name, first_name, job_title, gender, date_of_birth, date_of_hire, department_id) VALUES ('Daviau', 'Rob', 'Head of Testing', 'M', '1970-06-10', '1999-02-21', 3);
INSERT INTO employee (last_name, first_name, job_title, gender, date_of_birth, date_of_hire, department_id) VALUES ('Knizia', 'Reiner', 'Lead Designer', 'M', '1957-11-16', '1992-04-02', 1);
INSERT INTO employee (last_name, first_name, job_title, gender, date_of_birth, date_of_hire, department_id) VALUES ('Hargrave', 'Elizabeth', 'Head of HR', 'F', '1991-10-09', '2019-01-21', 2);
INSERT INTO employee (last_name, first_name, job_title, gender, date_of_birth, date_of_hire, department_id) VALUES ('Blum', 'Mal', 'Tester', 'O', '1988-07-07', '2007-03-30', 3);
INSERT INTO employee (last_name, first_name, job_title, gender, date_of_birth, date_of_hire, department_id) VALUES ('Rosenberg', 'Uwe', 'Designer', 'M', '1970-03-27', '1997-04-21', 1);
INSERT INTO employee (last_name, first_name, job_title, gender, date_of_birth, date_of_hire, department_id) VALUES ('Cardouat', 'Marie', 'Tester', 'F', '1981-10-20', '2007-04-11', 3);
INSERT INTO project (name, start_date) VALUES ('A Feast For Odin', '2019-12-17');
INSERT INTO project (name, start_date) VALUES ('Scythe', '2020-01-02');
INSERT INTO project (name, start_date) VALUES ('Samurai', '2019-02-27');
INSERT INTO project (name, start_date) VALUES ('Downforce', '2020-02-13');
INSERT INTO employee_project (employee_id, project_id) VALUES (8, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (6, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (5, 3);
INSERT INTO employee_project (employee_id, project_id) VALUES (4, 4);
INSERT INTO employee_project (employee_id, project_id) VALUES (5, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (5, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (5, 4);
INSERT INTO employee_project (employee_id, project_id) VALUES (4, 3);