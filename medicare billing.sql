create database medicare;
use  medicare;
create table admin
(
userid varchar(45) not null primary key,
pwd varchar(45) not null
);
insert into admin (userid,pwd) values ('admin','admin');
create table frontdesk
(
frontdeskid varchar(45) not null primary key,
fname varchar(45) not null,
lname varchar(45) not null,
pwd varchar(45) not null,
gender varchar(45) not null,
phone varchar(45) not null,
dob varchar(45) not null,
email varchar(45) not null,
status varchar(45) not null default 'not approved'
);
create table patient
(
patientid varchar(45) not null primary key,
fname varchar(45) not null,
lname varchar(45) not null,
dob varchar(45) not null,
gender varchar(45) not null,
phone varchar(45) not null,
address varchar(45) not null,
symptoms varchar(45) not null,
userid varchar(45) ,
consultancy_bill int default 0,
room_bill int default 0,
service_bill int default 0,
medication_bill int default 0,
total_bill int default 0,
bill_status varchar(45) default 'not paid'
);

create table user
(
userid varchar(45) not null primary key,
fname varchar(45) not null,
lname varchar(45) not null,
pwd varchar(45) not null,
favpet varchar(45),
favnumber varchar(45),
favcolour varchar(45)
);

create table tickets
(
userid varchar(45)primary key,
query varchar(255) not null,
resolution varchar(255) default 'not resolved'
);

create table rooms
(
roomtype varchar(45) primary key,
price int
);
insert into rooms(roomtype,price) values ('roomtype1',10000),('roomtype2',20000),('roomtype3',30000);

create table consultancies
(
consultansytype varchar(45) primary key,
price int
);
insert into consultancies(consultansytype,price) values ('doc1',1000),('doc2',2000),('doc3',3000);

create table medicines
(
medicationtype varchar(45) primary key,
price int
);
insert into medicines(medicationtype,price) values ('medication1',10),('medication2',20),('medication3',30);


create table services
(
servicetype varchar(45) primary key,
price int
);
insert into services(servicetype,price) values ('service1',100),('service2',200),('service3',300);


create table reviews
(
userid varchar(45) primary key,
review varchar(255) not null
);
