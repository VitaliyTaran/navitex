insert into sensor (name,longitude,latitude) values('Академия Связи','53.924594','27.666809');
insert into sensor (name,longitude,latitude) values('ст.м Борисовский Тракт','53.938628','27.66608');
insert into sensor (name,longitude,latitude) values('ст.м Восток','53.934525','27.651063');
insert into sensor (name,longitude,latitude) values('мост ул Филимонова и пр. Независимости','53.931015','27.638782');
insert into sensor (name,longitude,latitude) values('ул Ф.Скорины и Филимонова','53.929377','27.639395');
insert into sensor (name,longitude,latitude) values('ул Ф.Скорины проезд Дачный','53.926973','27.655037');
insert into sensor (name,longitude,latitude) values('БНТУ к20','53.93109','27.668435');

insert into sensor_description(sensor_id, co2, lpg, co, ch4, dust, temp, hum, pressure, created) VALUES (1,9,1,1,1,1,1,1,1,'2018-12-12');
insert into sensor_description(sensor_id, co2, lpg, co, ch4, dust, temp, hum, pressure, created) VALUES (2,1,1,1,2000,1,1,1,1,'2018-12-12');
insert into sensor_description(sensor_id, co2, lpg, co, ch4, dust, temp, hum, pressure, created) VALUES (3,1,1,1,1,1,1,1,1,'2018-12-12');
insert into sensor_description(sensor_id, co2, lpg, co, ch4, dust, temp, hum, pressure, created) VALUES (4,1,1000,1,1,1,1,1,1,'2018-12-12');
insert into sensor_description(sensor_id, co2, lpg, co, ch4, dust, temp, hum, pressure, created) VALUES (5,1,1,1,1,1,1,1,1,'2018-12-12');
insert into sensor_description(sensor_id, co2, lpg, co, ch4, dust, temp, hum, pressure, created) VALUES (6,1,1,1,1,3500,1,1,1,'2018-12-12');
insert into sensor_description(sensor_id, co2, lpg, co, ch4, dust, temp, hum, pressure, created) VALUES (7,1,1,1,1,1,1,1,1,'2018-12-12');

insert into edge(first_sensor_id,second_sensor_id) values ('1','2');
insert into edge(first_sensor_id,second_sensor_id) values ('2','1');
insert into edge(first_sensor_id,second_sensor_id) values ('2','3');
insert into edge(first_sensor_id,second_sensor_id) values ('3','2');
insert into edge(first_sensor_id,second_sensor_id) values ('3','4');
insert into edge(first_sensor_id,second_sensor_id) values ('4','3');
insert into edge(first_sensor_id,second_sensor_id) values ('4','5');
insert into edge(first_sensor_id,second_sensor_id) values ('5','4');
insert into edge(first_sensor_id,second_sensor_id) values ('5','6');
insert into edge(first_sensor_id,second_sensor_id) values ('6','5');
insert into edge(first_sensor_id,second_sensor_id) values ('6','3');
insert into edge(first_sensor_id,second_sensor_id) values ('3','6');
insert into edge(first_sensor_id,second_sensor_id) values ('6','1');
insert into edge(first_sensor_id,second_sensor_id) values ('1','6');

insert into users(login, password, is_admin) VALUES ('admin','admin',true);
insert into users(login, password, is_admin) VALUES ( 'vit', 'vit', true);
