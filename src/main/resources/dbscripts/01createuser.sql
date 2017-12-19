create table User(ID int NOT NULL AUTO_INCREMENT,
name varchar(30) not null,
mobile varchar(30) not null,
email varchar(40) not null,
user_name varchar(20) not null,
password varchar(128) not null,
address varchar(60) not null,
gender varchar(6),
date Date,
pan_num varchar(10),
experience int,
user_type varchar(20) not null,
primary key (ID)
)