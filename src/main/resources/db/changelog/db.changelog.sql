--liquibase formatted sql

--changeset apeshko:1
CREATE TABLE tickets (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(250) NOT NULL
);
--rollback drop table tickets;

--changeset apeshko:2
ALTER TABLE tickets
ADD desc VARCHAR(250);