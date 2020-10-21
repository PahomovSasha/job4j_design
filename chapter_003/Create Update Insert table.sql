create database users;

create table users
(
    id       serial primary key,
    name     text,
    age      int,
    birthday date
);

insert into users(name, age, birthday)
VALUES ('Саша', 18, '10/10/2010');

select *
from users;

update users
set name = 'Паша';

delete
from users;