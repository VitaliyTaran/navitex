CREATE TABLE sensor
(
    id        SERIAL primary key,
    name      varchar(250),
    latitude  double precision,
    longitude double precision,
    mark      int
);

create table edge
(
    id               SERIAL primary key,
    first_sensor_id  int,
    second_sensor_id int,
    cost             int,
    distance         double precision,
    average_mark     float,
    foreign key (first_sensor_id) references sensor (id),
    foreign key (second_sensor_id) references sensor (id)
);
