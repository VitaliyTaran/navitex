insert into sensor (name) values('1');
insert into sensor (name) values('2');
insert into sensor (name) values('3');
insert into sensor (name) values('4');
insert into sensor (name) values('5');

insert into edge(first_sensor_id,second_sensor_id,cost) values (1,2,1);
insert into edge(first_sensor_id,second_sensor_id,cost) values (2,1,1);
insert into edge(first_sensor_id,second_sensor_id,cost) values (2,3,1);
insert into edge(first_sensor_id,second_sensor_id,cost) values (3,2,1);
insert into edge(first_sensor_id,second_sensor_id,cost) values (3,4,1);
insert into edge(first_sensor_id,second_sensor_id,cost) values (4,3,1);
insert into edge(first_sensor_id,second_sensor_id,cost) values (4,5,1);
insert into edge(first_sensor_id,second_sensor_id,cost) values (5,4,1);
insert into edge(first_sensor_id,second_sensor_id,cost) values (5,1,1);
insert into edge(first_sensor_id,second_sensor_id,cost) values (1,5,1);