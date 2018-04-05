--liquibase formatted sql


--changeset rafael-ito:04
--comment: create sequence seq_aircraft
create sequence fm.seq_aircraft minvalue 1 maxvalue 999999999999999999 increment by 1 start with 1;
--rollback drop sequence fm.seq_aircraft;

--changeset rafael-ito:05
--comment: create aircraft table
create table fm.aircraft (
    id_aircraft serial primary key,
    model varchar(255) not null
)
--rollback drop table fm.aircraft;


--changeset rafael-ito:06
--comment: inserting fictional data
insert into fm.aircraft (model) values ('Phenom 300');
insert into fm.aircraft (model) values ('E2');
--rollback delete from fm.aircraft where model in ('Phenom 300', 'E2');