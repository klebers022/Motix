CREATE TABLE IF NOT EXISTS users (
                                     id         BIGSERIAL PRIMARY KEY,
                                     username   VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(100) NOT NULL,
    enabled    BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS roles (
                                     id   BIGSERIAL PRIMARY KEY,
                                     name VARCHAR(50) NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS users_roles (
                                           user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    role_id BIGINT NOT NULL REFERENCES roles(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
    );
