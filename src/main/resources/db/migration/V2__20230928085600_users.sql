CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(150) NOT NULL);

CREATE INDEX users_login_idx ON users(login);