insert into course_master (course_name,course_code,fees) values ('Angular','ANG',13800);	
insert into course_master (course_name,course_code,fees) values ('Python','PYT',10800);
insert into course_master (course_name,course_code,fees) values ('Java','JAVA',10800);


insert into trainer_master (trainer_name,trainer_mobile_no,trainer_email,trainer_type,compansantion_type,percentage,
fixed_pay) values ('keyur','7387029671','keyurjava27@gmail.com','PART_TIME','PER',40,0);	


insert into trainer_master (trainer_name,trainer_mobile_no,trainer_email,trainer_type,compansantion_type,percentage,
fixed_pay) values ('jatin','7387029111','jatinpyt11@gmail.com','FULL_TIME','PER',100,0);	

insert into trainer_course_detail (trainer_id,course_id) values(1,1);
insert into trainer_course_detail (trainer_id,course_id) values(2,2);
insert into trainer_course_detail (trainer_id,course_id) values(1,3);

insert into batch_master (batch_name,batch_type,batch_timing,course_id,trainer_id,start_date,end_date)
values('E_keyur_Angular_1','WEEKEND','8:00 AM-10:00 AM',1,1,'2019-11-23',null);

insert into batch_master (batch_name,batch_type,batch_timing,course_id,trainer_id,start_date,end_date)
values('E_jatin_Python_1','WEEKEND','02:00 PM-05:00 PM',2,2,'2019-11-24',null);

insert into batch_master (batch_name,batch_type,batch_timing,course_id,trainer_id,start_date,end_date)
values('E_keyur_Java_1','WEEKEND','01:00 PM-03:00 PM',3,1,'2019-11-23',null);

insert into student_registration(name,mobile_no,email,course_id,total_fees,discount,final_fees,fees_paid,fees_remaining,fees_status,registration_date)
values('Sachin','9898012124','sachin.cric@gmail.com',1,13800,10,12420,0,12420,'NOT_PAID',
'2019-11-19');
