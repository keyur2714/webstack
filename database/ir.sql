create database if not exists institute_run;

use institute_run;

create table if not exists course_master(
course_id int primary key AUTO_INCREMENT,
course_code varchar(50) not null,
course_name varchar(100) not null,
fees int
);

create table if not exists trainer_master(
trainer_id int primary key AUTO_INCREMENT,
trainer_name varchar(100) not null,
trainer_mobile_no varchar(10),
trainer_email varchar(100),
trainer_type varchar(50) not null,
compansantion_type varchar(50) not null,
percentage int,
fixed_pay int	
);

create table if not exists trainer_course(
trainer_id int not null,
course_id int not null
);

create table if not exists batch_master(
batch_id int primary key AUTO_INCREMENT,
batch_name varchar(100) not null,
batch_type varchar(50) not null,
batch_timing varchar(100),
course_id int not null,
trainer_id int not null,
start_date date,
end_date date,
foreign key (course_id) references course_master(course_id),
foreign key (trainer_id) references trainer_master(trainer_id)
);

create table if not exists student_registration(
student_id int primary key AUTO_INCREMENT,
name varchar(50) not null,
mobile_no varchar(15) not null,
email varchar(100) not null,
course_id int not null,
total_fees int,
discount int,
final_fees int,
fees_paid int,
fees_remaining int,
fees_status varchar(20),
registration_date date,
foreign key (course_id) references course_master(course_id)
);

create table if not exists student_payments(
payment_id int primary key AUTO_INCREMENT,
payment_type varchar(50),
payment_ref_no varchar(100),
payment_date date,
payment_received int not null,
student_id int not null,
foreign key (student_id) references student_registration(student_id)
);

ALTER TABLE student_registration
ADD COLUMN batch_id INT;

ALTER TABLE student_registration 
ADD FOREIGN KEY (batch_id) REFERENCES batch_master(batch_id);