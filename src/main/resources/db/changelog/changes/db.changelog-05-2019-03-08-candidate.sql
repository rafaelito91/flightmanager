--liquibase formatted sql


--changeset rafael-ito:17
--comment: create sequence seq_candidate
create sequence fm.seq_candidate minvalue 1 maxvalue 999999999999999999 increment by 1 start with 1;
--rollback drop sequence fm.seq_candidate;

--changeset rafael-ito:18
--comment: create sequence seq_candidate_photo
create sequence fm.seq_candidate_photo minvalue 1 maxvalue 999999999999999999 increment by 1 start with 1;
--rollback drop sequence fm.seq_candidate;


--changeset rafael-ito:19
--comment: create flight table
create table fm.candidate (
    id_candidate serial primary key,
    name varchar(255) not null,
    age bigint,
    distance bigint,
    description varchar(2000)
)
--rollback drop table fm.flight;

--changeset rafael-ito:20
--comment: create flight table
create table fm.candidate_photo (
    id_candidate_photo serial primary key,
    path varchar(1000) not null,
    candidate_id bigint not null
)
--rollback drop table fm.flight;

--changeset rafael-ito:21
--comment: create candidate foreign key constraint
alter table fm.candidate_photo add constraint fk1candidatephoto foreign key (candidate_id) references fm.candidate (id_candidate);
--rollback alter table fm.candidate_photo drop constraint fk1candidatephoto;

--changeset rafael-ito:22
--comment: adding candidates and photos
insert into fm.candidate (id_candidate, name, age, distance, description) values (nextval('fm.seq_candidate'), 'Test Candidate', 23, 40, 'Sou uma descricao generica');
insert into fm.candidate_photo (id_candidate_photo, path, candidate_id) values (nextval('fm.seq_candidate_photo'), 'http://www.google.com', currval('fm.seq_candidate'));
--rollback delete from fm.candidate where id_candidate = 1
--rollback delete from fm.candidate_photo where id_candidate_photo = 1