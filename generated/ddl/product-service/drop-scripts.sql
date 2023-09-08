alter table if exists image drop constraint if exists FKgpextbyee3uk9u6o2381m7ft1;
alter table if exists product drop constraint if exists FK1mtsbur82frn64de7balymq9s;
drop table if exists category cascade;
drop table if exists image cascade;
drop table if exists product cascade;
