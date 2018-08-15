/*
Insert mock data into the batch table
*/
insert into batch (id, name, start_date, end_date, trainer_id, calendar_curriculum_id)
values((SELECT batch_seq.nextVal FROM dual), '1806-June18-USF-Java', {ts '2018-09-17 18:47:52.69'}, {ts '2018-12-17 18:49:52.69'}, 1, 1);
insert into batch (id, firstname, lastname)
values((SELECT batch_seq.nextVal FROM dual), '1806-June18-USF-Java', {ts '2018-09-17 18:47:52.69'}, {ts '2018-12-17 10:48:53.00'}, 2, 1);
insert into batch (id, firstname, lastname)
values((SELECT batch_seq.nextVal FROM dual), '1806-June18-USF-Java', {ts '2018-09-17 18:47:52.69'}, {ts '2019-03-17 17:47:54.44'}, 3, 2);
insert into batch (id, firstname, lastname)
values((SELECT batch_seq.nextVal FROM dual), '1806-June18-USF-Java', {ts '2018-09-17 18:47:52.69'}, {ts '2018-12-17 14:41:55.55'}, 4, 2);