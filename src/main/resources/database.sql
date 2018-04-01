create table Employee(id int NOT NULL,
name varchar(255) NOT NULL,
email varchar(255) NOT NULL,
phone int,
position varchar(255),
salary int
PRIMARY KEY(id));

create table Manager(
id int NOT NULL,
username varchar(255),
password varchar(255),
PRIMARY KEY(id)
);

create table Admin(
id int NOT NULL,
username varchar(255),
password varchar(255),
PRIMARY KEY(id));

create table Project(
id int NOT NULL,
manager int,
PRIMARY KEY(id),
FOREIGN KEY( manager) references Manager (id)
);


create table Timesheet(
id int NOT NULL,
employee_id int,
task_id int,
hours time,
Date date,
from_time time,
to_time time,
PRIMARY KEY (id),
FOREIGN KEY(employee_id) REFERENCES Employee(id),
FOREIGN KEY(task_id) REFERENCES Task(id)
);

create table Assigned_Employee(
task_id int foreign key references Task(id),
project_id int foreign key references Project(id),
primary key(task_id,project_id),
);

-- add few employees
insert into Employee values(1, 'Steve Jobs', 'steve@Jkart.com', '6188161618', 'Team Lead', 200000);
insert into Employee values(2, 'Bill Gates', 'gates@Jkart.com', '1236549875','Technology analyst', 150000);
insert into Employee values(3, 'Steve Wozniak', 'Wozniak@Jkart.com', '8764562390','Systems Engineer', 130000);
insert into Employee values(4, 'Paul Allen','Paul@Jkart.com','8079456823','Senior test engineer',100000 );
 
-- add few managers
insert into Manager values(1, 'Eric', '123');
insert into Manager values(2, 'Steve','12345');
 
-- add admin
insert into Admin values(1,'admin','pass');

-- add some tasks
insert into Project values(1, 1);
insert into Project values(2, 2);
 
-- connect tasks to some employees
insert into Assigned_Employee values (1, 1);
insert into Assigned_Employee values (1, 3);
insert into Assigned_Employee values (1, 4);
insert into Assigned_Employee values (2, 2);
insert into Assigned_Employee values (2, 1);


create table Timesheet(
id int NOT NULL,
employee_id int,
task_id int,
hours time,
Date date,
from_time time,
to_time time,
PRIMARY KEY (id),
FOREIGN KEY(employee_id) REFERENCES Employee(id),
FOREIGN KEY(task_id) REFERENCES Task(id)
);
-- create some timesheets on tasks
insert into timesheet values(1,
1,1,5,2018-31-03,01:00:00,02:45:00
);
 
insert into timesheet values(2,
2,3,8,2018-30-03,04:00:00,05:30:00
);


