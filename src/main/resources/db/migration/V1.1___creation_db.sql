CREATE TABLE sensor
(
    id        SERIAL primary key,
    name      varchar(250),
    latitude  double precision,
    longitude double precision
);

create table edge
(
    id               SERIAL primary key,
    first_sensor_id  int,
    second_sensor_id int,
    foreign key (first_sensor_id) references sensor (id),
    foreign key (second_sensor_id) references sensor (id)
);

create table users
(
    id       SERIAL primary key,
    login    varchar(250),
    password varchar(250),
    is_admin boolean
);

create table sensor_description
(
    sensor_id serial primary key,
    co2       double precision,
    lpg       double precision,
    co        double precision,
    ch4       double precision,
    dust      double precision,
    temp      double precision,
    hum       double precision,
    pressure  double precision,
    created   date,
    foreign key (sensor_id) references sensor (id)
);
