

CREATE TABLE employee
(
 employeeId   serial,
 firstName    varchar(50) NOT NULL,
 lastName     varchar(50) NOT NULL,
 addressId    integer NULL,
 contactEmail varchar(50) NOT NULL,
 companyEmail varchar(50) NOT NULL,
 birthDate    varchar(50) NOT NULL,
 hiredDate    varchar(50) NOT NULL,
 CONSTRAINT PK_employee PRIMARY KEY (employeeId)
);



CREATE TABLE address
(
 addressId  serial,
 street     varchar(50) NOT NULL,
 suite      varchar(50) NULL,
 city       varchar(50) NOT NULL,
 state      varchar(2) NOT NULL,
 zipCode    integer NOT NULL,
 country    varchar(3) NOT NULL,
 CONSTRAINT PK_address PRIMARY KEY (addressId)
);




CREATE TABLE skills
(
 skillsId   serial,
 skillsName varchar(50) NOT NULL,
 skillsType varchar(100) NULL,
 CONSTRAINT PK_skills PRIMARY KEY (skillsId)
);



CREATE TABLE employee_skills
(
 employeeId integer NOT NULL,
 skillsId   integer NOT NULL,
 experience integer NOT NULL,
 summary    varchar(100) NOT NULL
);



ALTER TABLE employee ADD CONSTRAINT fk_addressId FOREIGN KEY (addressId) REFERENCES address (addressId);
ALTER TABLE employee_skills ADD CONSTRAINT fk_employeeId FOREIGN KEY (employeeId) REFERENCES employee (employeeId);
ALTER TABLE employee_skills ADD CONSTRAINT fk_skillsId FOREIGN KEY (skillsId) REFERENCES skills (skillsId);






















