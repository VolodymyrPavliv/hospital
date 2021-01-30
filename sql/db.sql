CREATE TABLE IF NOT EXISTS roles (
    id                   INT PRIMARY KEY AUTO_INCREMENT,
    name                 VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS users (
    id             INT PRIMARY KEY AUTO_INCREMENT,
    name 		   VARCHAR(50),
    surname        VARCHAR(50),
    email          VARCHAR(50),
    password       VARCHAR(50) NOT NULL,
    role_id        INT,
    FOREIGN KEY(role_id) REFERENCES roles(id)
);