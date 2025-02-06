drop database if exists ems_db;
create database ems_db;
use ems_db;

drop table if exists employee;

drop table if exists department;
CREATE TABLE department (
    dept_id BIGINT UNSIGNED PRIMARY KEY unique NOT NULL auto_increment,
    dept_name VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    budget bigint unsigned NOT NULL
);

insert into department() 
	values(null,'Corporate', '1-800-999-9999', 1500000000);
insert into department(dept_name,phone,budget) 
	values('Operations Management', '1-800-888-8888', 35000000);
insert into department(dept_name,phone,budget) 
	values('Human Resources', '1-800-777-7777', 15000000);
insert into department(dept_name,phone,budget) 
	values('Finance', '1-800-567-1436', 50000000);
insert into department(dept_name,phone,budget) 
	values('Marketing', '1-800-234-1543', 50000000);
insert into department(dept_name,phone,budget) 
	values('Information Technology', '1-800-456-7890', 35000000);

drop table if exists employee;
CREATE TABLE employee (
    emp_id BIGINT UNSIGNED PRIMARY KEY unique NOT NULL auto_increment,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    emp_date date NOT NULL,
    dept bigint unsigned NOT NULL,
    foreign key (dept) REFERENCES department(dept_id)
);

insert into employee(first_name, last_name,emp_date,dept) 
	values('John', 'Doe', '2001-06-02', 1);
insert into employee(first_name, last_name,emp_date,dept) 
	values('Jane', 'Doe', '2001-06-02', 1);
insert into employee(first_name, last_name,emp_date,dept) 
	values('Fred', 'Dorse', '2001-06-02', 2);
insert into employee(first_name, last_name,emp_date,dept) 
	values('Sarah', 'McCoughlan', '2001-06-02', 2);
insert into employee(first_name, last_name,emp_date,dept) 
	values('Darren', 'Murphy', '2001-06-02', 3);
insert into employee(first_name, last_name,emp_date,dept) 
	values('James', 'Sunderland', '2001-06-03', 4);
insert into employee(first_name, last_name,emp_date,dept) 
	values('Maria', 'Sunderland', '2001-06-03', 4);
insert into employee(first_name, last_name,emp_date,dept) 
	values('Angela', 'Orosco', '2001-06-03', 4);
insert into employee(first_name, last_name,emp_date,dept) 
	values('Eddie', 'Dombrowski', '2001-06-03', 6);
    
-- select * from employee; 