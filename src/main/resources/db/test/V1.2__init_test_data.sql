insert into sensor (name,longitude,latitude) values('1','72.14034','169.67485');
insert into sensor (name,longitude,latitude) values('2','-56.73142','178.15685');
insert into sensor (name,longitude,latitude) values('3','-37.46646','-88.29196');
insert into sensor (name,longitude,latitude) values('4','27.52873','-67.69225');
insert into sensor (name,longitude,latitude) values('5','71.54185','-79.73339');
insert into sensor (name,longitude,latitude) values('6','32.185','-43.73339');


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