--liquibase formatted sql

--changeset moroz:1
CREATE TABLE IF NOT EXISTS users (
                       id BIGSERIAL PRIMARY KEY,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

--changeset moroz:2
CREATE TABLE IF NOT EXISTS tasks (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       status VARCHAR(50) NOT NULL,
                       priority VARCHAR(50) NOT NULL ,
                       author_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                       executor_id BIGINT REFERENCES users(id) ON DELETE SET NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

--changeset moroz:3
CREATE TABLE IF NOT EXISTS comments (
                          id BIGSERIAL PRIMARY KEY,
                          task_id BIGINT NOT NULL REFERENCES tasks(id) ON DELETE CASCADE,
                          user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                          content TEXT NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);