create table car_body(
                            id serial primary key,
                            body_type varchar(255),
                            color varchar(255)
);

create table engine(
                         id serial primary key,
                         power numeric(10,1),
                         type varchar(255)
);

create table transmission(
                       id serial primary key,
                       type varchar(255),
                       number_gears integer
);

create table car(
                             id serial primary key,
                             brand varchar(255),
                             car_body_id int references car_body(id),
                             engine_id int references engine(id),
                             transmission_id int references transmission(id)
);

insert into car_body(body_type, color) values ('Родстер', 'Красный');
insert into car_body(body_type, color) values ('Лифтбэк', 'Синий');
insert into car_body(body_type, color) values ('Седан', 'Белый');
insert into car_body(body_type, color) values ('Седан', 'Красный');
insert into car_body(body_type, color) values ('Хэтчбэк', 'Красный');

insert into engine(power, type) values (105.1, 'Бензин');
insert into engine(power, type) values (200.1, 'Дизель');
insert into engine(power, type) values (44.1, 'Бензин');
insert into engine(power, type) values (99.9, 'Бензин');
insert into engine(power, type) values (149.9, 'Бензин');

insert into transmission(type, number_gears) values ('Ручная', 5);
insert into transmission(type, number_gears) values ('Автоматическая', 4);
insert into transmission(type, number_gears) values ('Автоматическая', 5);
insert into transmission(type, number_gears) values ('Автоматическая', 6);
insert into transmission(type, number_gears) values ('Автоматическая', 6);

insert into car (brand, car_body_id, engine_id, transmission_id) values ('Лада', 1,1,1);
insert into car(brand, car_body_id, engine_id, transmission_id) values ('Opel',1,2,5);
insert into car(brand, car_body_id, engine_id, transmission_id) values ('Geely',2,2,2);
insert into car(brand, car_body_id, engine_id, transmission_id) values ('Volkswagen',2,3,1);
insert into car(brand, car_body_id, engine_id, transmission_id) values ('Suzuki',3,2,4);

select c.brand, b.body_type, b.color, e.power, e.type, t.type, t.number_gears from car c, car_body b, engine e, transmission t
where c.car_body_id = b.id
and c.engine_id = e.id
and c.transmission_id = t.id;

select b.body_type, b.color from car c right join car_body b on c.car_body_id = b.id
where c.brand is null;

select e.type, e.power from car c right join engine e on c.engine_id = e.id
where c.brand is null;

select t.type, t.number_gears from car c right join transmission t on c.transmission_id = t.id
where c.brand is null;