--liquibase formatted sql


--changeset rafael-ito:01
--comment: create sequence seq_employee
create sequence fm.seq_employee minvalue 1 maxvalue 999999999999999999 increment by 1 start with 1;
--rollback drop sequence fm.seq_employee;

--changeset rafael-ito:02
--comment: create employees table
create table fm.employee (
    id_employee serial primary key,
    name varchar(255) not null
)
--rollback drop table fm.employee;


--changeset rafael-ito:03
--comment: inserting fictional data
insert into fm.employee (id_employee, name) values (nextval('fm.seq_employee'), 'João da Silva');
insert into fm.employee (id_employee, name) values (nextval('fm.seq_employee'), 'Maria Helena');
--rollback delete from fm.employee where name in ('João da Silva', 'Maria Helena');