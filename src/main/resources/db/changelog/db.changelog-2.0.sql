--liquibase formatted sql

--changeset moroz:1
ALTER TABLE users ADD COLUMN firstname VARCHAR(255);
ALTER TABLE users ADD COLUMN lastname VARCHAR(255);