--liquibase formatted sql


--changeset rafael-ito:07
--comment: create sequence seq_city
create sequence fm.seq_city minvalue 1 maxvalue 999999999999999999 increment by 1 start with 1;
--rollback drop sequence fm.seq_city;

--changeset rafael-ito:08
--comment: create city table
create table fm.city (
    id_city serial primary key,
    name varchar(255) not null
)
--rollback drop table fm.city;


--changeset rafael-ito:09
--comment: inserting fictional data
insert into fm.city (id_city, name) values (nextval('fm.seq_city'), 'São José dos Campos');
insert into fm.city (id_city, name) values (nextval('fm.seq_city'), 'Madrid');
--rollback delete from fm.city where model in ('Phenom 300', 'E2');