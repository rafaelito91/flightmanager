--liquibase formatted sql


--changeset rafael-ito:01
--comment: Create sequence SEQ_EMPLOYEE
CREATE SEQUENCE FM.SEQ_EMPLOYEE MINVALUE 1 MAXVALUE 999999999999999999 INCREMENT BY 1 START WITH 1;
--rollback DROP SEQUENCE FM.SEQ_EMPLOYEE;

--changeset rafael-ito:02
--comment: Create employees table
CREATE TABLE FM.EMPLOYEE (
    ID_EMPLOYEE SERIAL PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
)
--rollback DROP TABLE FM.EMPLOYEE;

--changeset rafael-ito:03
--comment: Inserting fictional data
INSERT INTO FM.EMPLOYEE (NAME) VALUES ('João da Silva');
INSERT INTO FM.EMPLOYEE (NAME) VALUES ('Maria Helena');
--rollback DELETE FROM FM.EMPLOYEE WHERE NAME IN ('João da Silva', 'Maria Helena');