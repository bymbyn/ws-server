-- create schema user;
create table user (id int not null auto_increment, name varchar(255), surname varchar(255), email varchar(255), age int);
insert into user (name, surname, email, age) values ('Marcin', 'Bambynek', 'bymbyn@o2.pl', '33');
