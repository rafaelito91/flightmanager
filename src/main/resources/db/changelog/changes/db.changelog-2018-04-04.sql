--liquibase formatted sql

--changeset rafael-ito:01
--comment: Create employees table
CREATE TABLE FM.EMPLOYEE (
    ID_EMPLOYEE SERIAL PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
)
--rollback DROP TABLE FM.EMPLOYEE;


--changeset rafael-ito:02
--comment: INSERT FICTIONAL DATA
INSERT INTO FM.EMPLOYEE (NAME) VALUES ('João da Silva');
INSERT INTO FM.EMPLOYEE (NAME) VALUES ('Maria Helena');
--rollback DELETE FROM FM.EMPLOYEE WHERE NAME IN ('João da Silva', 'Maria Helena');