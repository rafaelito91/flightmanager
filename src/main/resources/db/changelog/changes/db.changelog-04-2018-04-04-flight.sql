--liquibase formatted sql


--changeset rafael-ito:10
--comment: create sequence seq_flight
create sequence fm.seq_flight minvalue 1 maxvalue 999999999999999999 increment by 1 start with 1;
--rollback drop sequence fm.seq_flight;

--changeset rafael-ito:11
--comment: create flight table
create table fm.flight (
    id_flight serial primary key,
    pilot_id bigint not null,
    aircraft_id bigint not null,
    origin bigint not null,
    destination bigint not null,
    start timestamp not null,
    final timestamp not null
)
--rollback drop table fm.flight;

--changeset rafael-ito:12
--comment: create pilot foreign key constraint
alter table fm.flight add constraint fk1flight foreign key (pilot_id) references fm.employee (id_employee);
--rollback alter table fm.flight drop constraint fk1flight;

--changeset rafael-ito:13
--comment: create aircraft foreign key constraint
alter table fm.flight add constraint fk2flight foreign key (aircraft_id) references fm.aircraft (id_aircraft);
--rollback alter table fm.flight drop constraint fk2flight;

--changeset rafael-ito:14
--comment: create city foreign key constraint
alter table fm.flight add constraint fk3flight foreign key (origin) references fm.city (id_city);
--rollback alter table fm.flight drop constraint fk3flight;

--changeset rafael-ito:15
--comment: create city foreign key constraint
alter table fm.flight add constraint fk4flight foreign key (destination) references fm.city (id_city);
--rollback alter table fm.flight drop constraint fk4flight;

--changeset rafael-ito:16
--comment: adding flights
insert into fm.flight (pilot_id, aircraft_id, origin, destination, start, final) values (1, 1, 1, 2, '2018-04-05 17:59:32', '2018-04-06 12:12:11');
--rollback delete from fm.flight where id