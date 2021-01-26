create table departments(
                            id serial primary key,
                            name varchar(255)
);

create table emploees(
                         id serial primary key,
                         name varchar(255),
                         departments_id int references departments(id)
);

insert into departments(name) values ('Departments 1');
insert into departments(name) values ('Departments 2');
insert into departments(name) values ('Departments 3');

insert into emploees(name, departments_id) values ('Sasha', 1);
insert into emploees(name, departments_id) values ('Viktor', 2);
insert into emploees(name, departments_id) values ('Denis', 3);
insert into emploees(name, departments_id) values ('Dmitriy', null);
insert into emploees(name, departments_id) values ('Ivan', null);
insert into emploees(name, departments_id) values ('Igor', 1);

select * from emploees d left join departments o on d.departments_id = o.id;
select * from emploees d right join departments o on d.departments_id = o.id;
select * from emploees d full join departments o on d.departments_id = o.id;
select * from emploees d cross join departments o;

select * from emploees d left join departments o on d.departments_id = o.id
where o.name is null ;

select * from emploees d left join departments o on d.departments_id = o.id;
select * from departments o right join emploees d on d.departments_id = o.id;

create table teens(
                            id serial primary key,
                            name varchar(255),
                            gender varchar(40)
);

insert into teens(name, gender) values ('Sasha', 'мужской');
insert into teens(name, gender) values ('Viktor', 'мужской');
insert into teens(name, gender) values ('Denis', 'мужской');
insert into teens(name, gender) values ('Alina', 'женский');
insert into teens(name, gender) values ('Ivan', 'мужской');
insert into teens(name, gender) values ('Elena', 'женский');

select * from teens d cross join teens o;