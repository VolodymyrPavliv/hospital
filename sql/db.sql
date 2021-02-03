CREATE TABLE IF NOT EXISTS role (
    id                   INT PRIMARY KEY AUTO_INCREMENT,
    name                 VARCHAR(45) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS user (
    id             INT PRIMARY KEY AUTO_INCREMENT,
    name 		   VARCHAR(64),
    surname        VARCHAR(64),
    email          VARCHAR(64),
    password       VARCHAR(128) NOT NULL,
    role_id        INT,
    birthday       DATE,
    FOREIGN KEY(role_id) REFERENCES role(id)
);